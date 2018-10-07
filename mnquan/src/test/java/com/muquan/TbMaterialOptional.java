package com.muquan;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkCouponGetRequest;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkCouponGetResponse;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;
import net.sf.json.JSONObject;
import org.junit.Test;

/**
 * <p>
 * 通用物料搜索API（导购）
 * </p>
 * User: wangkecheng Date: 2018/9/29
 */
public class TbMaterialOptional{

    public final static String url = "https://eco.taobao.com/router/rest";
    public final static String appkey = "24810297";
    public final static String secret = "76250cfab3f567fdb5e90e7d03c1b10c";
    public final static long adzone_id = 272988181;

    @Test
    public void getProducts() throws ApiException {

        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
        req.setPageSize(20L);//每页数
        req.setPageNo(1L);//第几页
        req.setSort("total_sales");//按销量排序
        req.setQ("女装");
        req.setHasCoupon(true);
        req.setAdzoneId(adzone_id);
        req.setNeedFreeShipment(true);//是否包邮
        req.setIncludeGoodRate(true);
        TbkDgMaterialOptionalResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }

    @Test
    public void getProductByItemUrl() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
        req.setQ("https://detail.tmall.com/item.htm?id=577406087388");
        req.setAdzoneId(adzone_id);
        TbkDgMaterialOptionalResponse rsp = client.execute(req);
        JSONObject jsonObject = JSONObject.fromObject(rsp.getBody());
        String tbkResp = jsonObject.get("tbk_dg_material_optional_response").toString();
        JSONObject jsonObject1 = JSONObject.fromObject(tbkResp);
        String resultList = jsonObject1.get("result_list").toString();
        JSONObject jsonObject2 = JSONObject.fromObject(resultList);
        String mapData = jsonObject2.get("map_data").toString();
    }

    @Test
    public void getToken() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
        req.setText("这是一个美好的开始");
        req.setUrl("https://uland.taobao.com/coupon/edetail?e=v%2F%2Bm9QkxOkMNfLV8niU3RwXoB%2BDaBK5LQS0Flu%2FfbSp4QsdWMikAalrisGmre1Id522H2TxuqpLxL7BKMus%2Fa8qHYiKvbXh9%2BMUwzxYlSKGoDllHV3UCjWte55OvkP9PajgWy6j3MQPHgO%2Fqpd5%2BLablvhY7E%2BFINKDrySQOjLanKJhI9BhLrFUuZt7vPzvA09n1P0j5XaIJP8D1%2BglCLSUzVkkdwsIm&&app_pvid=0b08283815382335930873664d089b&ptl=floorId:2836;app_pvid:0b08283815382335930873664d089b;tpp_pvid:100_11.182.89.157_125636_1561538233593102230&union_lens=lensId:0b015e8a_0c90_16625dded1f_4e14");
        req.setLogo("https://img.alicdn.com/bao/uploaded/i4/3087008040/O1CN0129GMpGrnm3U5KXv_!!3087008040.jpg");
        TbkTpwdCreateResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }

    @Test
    public void queryCouponMsg()throws ApiException{
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkCouponGetRequest req = new TbkCouponGetRequest();
        req.setItemId(3326470811l);
        req.setActivityId("1db9c8b20da540c7a51c3770bbf2f7a1");
        TbkCouponGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }

    @Test
    public void queryDetail() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
        req.setNumIids("561357302164");
        TbkItemInfoGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }
}
