package cn.mnquan.controller;

import cn.mnquan.manager.ITaoBaoManager;
import cn.mnquan.model.Page;
import cn.mnquan.model.TbMnCatItemDo;
import cn.mnquan.model.TbMnMaterialOptionalDo;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 描述
 * </p>
 * User: wangkecheng Date: 2018/9/25
 */
@Slf4j
@Controller
public class TaoBaoController extends BaseController{

    @Autowired
    private ITaoBaoManager taoBaoManager;
    /**
     * app优惠券入口
     * @return
     */
    @RequestMapping("/app")
    public String index(){
        return "page/index";
    }
    /**
     * 获取首页商品列表
     * @param page
     * @param response
     */
    @RequestMapping(value="/app/index/getProductList.do")
    public void getPageList(Page page, HttpServletResponse response){
        log.info("获取首页元素,page:{}",page.toString());
        List<TbMnMaterialOptionalDo> tbkItems = taoBaoManager.getProductList(page);
        sendMessages(response, JSON.toJSONString(tbkItems));
    }

    /**
     * 获取首页商品列表
     * @param page
     * @param response
     */
    @RequestMapping(value="/app/index/getCentreList.do")
    public void getCentreList(Page page, HttpServletResponse response){
        log.info("获取首页中心滚动图元素,page:{}",page.toString());
        List<TbMnMaterialOptionalDo> tbkItems = taoBaoManager.getCentreList(page);
        sendMessages(response, JSON.toJSONString(tbkItems));
    }

    /**
     * app跳转到分类
     * @return
     */
    @RequestMapping("/app/classify")
    public String skipClassify(){
        return "page/classify";
    }

    /**
     * 获取类目元素列表
     * @param catItemDo
     * @param response
     */
    @RequestMapping(value="/app/classify/getCatList.do")
    public void getCatList(TbMnCatItemDo catItemDo, HttpServletResponse response){
        log.info("获取类目元素列表");
        List<TbMnCatItemDo> catItemDos = taoBaoManager.getCatList(catItemDo);
        sendMessages(response, JSON.toJSONString(catItemDos));
    }

}
