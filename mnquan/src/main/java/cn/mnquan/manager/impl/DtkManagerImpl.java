package cn.mnquan.manager.impl;

import cn.mnquan.commons.Contents;
import cn.mnquan.manager.IDtkManager;
import cn.mnquan.mapper.TbMnMaterialOptionalMapper;
import cn.mnquan.mapper.TbMnProductMapper;
import cn.mnquan.model.*;
import cn.mnquan.utils.BeanMapperUtil;
import cn.mnquan.utils.DateUtil;
import cn.mnquan.utils.HttpClientUtils;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 描述
 * </p>
 * User: wangkecheng Date: 2018/9/29
 */
@Service
@Slf4j
public class DtkManagerImpl implements IDtkManager {

    @Autowired
    private TbMnProductMapper tbMnProductMapper;
    @Autowired
    private TbMnMaterialOptionalMapper tbMnMaterialOptionalMapper;

    /**
     * 业务入口
     */
    public void execute() throws ApiException {
        log.info("获取所有商品类目名称");
        TbMnProductDoExample example = new TbMnProductDoExample();
        example.createCriteria().andStateEqualTo("1");

        List<TbMnProductDo> productDos = tbMnProductMapper.selectByExample(example);
        //获取前15页的数据
        for(int i = 0 ; i < 1 ; i++){
            for(TbMnProductDo productDo : productDos){
                String url = Contents.DAK_URL+"?keywords="+productDo.getCategoryName()+"&xuan=keyword&page="+i+"&px=sell";
                HttpClientResponse rsp = HttpClientUtils.get(url);
                Document doc = Jsoup.parse(rsp.getResponseContent());
                Elements rows = doc.getElementsByClass("goods-item");
                for(int j = 0 ; j<rows.size() ; j++){
                    //获取商品id
                    String numIid = rows.get(j).attr("data_goodsid");
                    //判断商品是否已经存在
                    TbMnMaterialOptionalDoExample example1 = new TbMnMaterialOptionalDoExample();
                    example1.createCriteria().andNumIidEqualTo(Long.valueOf(numIid));

                    List<TbMnMaterialOptionalDo> list = tbMnMaterialOptionalMapper.selectByExample(example1);
                    if(list.size() > 0) continue;

                    String itemUrl = "https://detail.tmall.com/item.htm?id="+numIid;
                    //通过物料搜索接口获取优惠券信息
                    TaobaoClient client = new DefaultTaobaoClient(Contents.MATERIAL_OPTIONAL_URL, Contents.appkey, Contents.secret);
                    TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
                    req.setQ(itemUrl);
                    req.setAdzoneId(Contents.adzone_id);
                    TbkDgMaterialOptionalResponse optionalResponse = client.execute(req);
                    TbkDgMaterialOptionalResponse.MapData mapData = optionalResponse.getResultList().get(0);
                    //如果券有效期为空，则continue
                    if(null == mapData.getCouponStartTime()) continue;
                    //获取淘口令
                    String command = getCommand(mapData);

                    TbMnMaterialOptionalDo record = BeanMapperUtil.objConvert(mapData,TbMnMaterialOptionalDo.class);
                    record.setLevelOneCategoryId(Long.valueOf(productDo.getProductId()));
                    record.setCategoryId(Long.valueOf(productDo.getCategoryId()));
                    record.setTokenTime(DateUtil.dateFormat(new Date()));
                    record.setToken(command);
                    tbMnMaterialOptionalMapper.insertSelective(record);
                }
            }
        }
    }

    /**
     * 生成淘口令
     * @param mapData
     * @return
     */
    private String getCommand(TbkDgMaterialOptionalResponse.MapData mapData) {
        String tbkCode="";
        try {
            TaobaoClient client = new DefaultTaobaoClient(Contents.MATERIAL_OPTIONAL_URL, Contents.appkey, Contents.secret);
            TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
            req.setText(mapData.getTitle());
            req.setUrl("https:"+mapData.getCouponShareUrl());
            req.setLogo(mapData.getPictUrl());
            TbkTpwdCreateResponse rsp = client.execute(req);
            if("" == rsp.getErrorCode()){
                tbkCode = rsp.getData().getModel();
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return tbkCode;
    }
}
