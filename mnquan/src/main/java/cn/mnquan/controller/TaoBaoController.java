package cn.mnquan.controller;

import cn.mnquan.manager.ITaoBaoManager;
import cn.mnquan.model.*;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
     * @param optionalDo
     * @param response
     */
    @RequestMapping(value="/app/index/getProductList.do")
    public void getPageList(TbMnMaterialOptionalDo optionalDo, HttpServletResponse response){
        log.info("获取首页元素,optionalDo:{}",optionalDo.toString());
        List<TbMnMaterialOptionalDo> optionalDos = taoBaoManager.getProductList(optionalDo);
        sendMessages(response, JSON.toJSONString(optionalDos));
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

    /**
     * 跳转到二级类目列表
     * @param catItemDo
     * @param model
     */
    @RequestMapping(value="/app/classify/skipProduct.do",method = RequestMethod.GET)
    public String skipProduct(TbMnCatItemDo catItemDo, Model model){
        log.info("跳转到指定的产品列表,catItemDo{}",catItemDo);
        List<TbMnCatItemDo> catItemDos = taoBaoManager.getCatList(catItemDo);

        //获取一级类目名称
        TbMnCatDo catDo = taoBaoManager.getCatName(catItemDo.getCatId());
        model.addAttribute("catItemDos",catItemDos);
        model.addAttribute("catName",catDo.getCatName());
        model.addAttribute("catId",catItemDo.getCatId());
        return "page/classify_product";
    }

    /**
     * 跳转到产品列表
     * @param optionalDo
     * @param model
     */
    @RequestMapping(value="/app/classify/skipProductList.do",method = RequestMethod.GET)
    public String skipProductList(TbMnMaterialOptionalDo optionalDo, Model model){
       /* log.info("跳转到产品列表,optionalDo:{}",optionalDo.toString());
        List<TbMnMaterialOptionalDo> optionalDos = taoBaoManager.getProductList(optionalDo);*/

        //获取类目名称
        TbMnCatItemDo itemDo = taoBaoManager.getCategoryName(optionalDo);
       /* model.addAttribute("optionalDos",optionalDos);*/
        model.addAttribute("categoryName",itemDo.getCategoryName());
        return "page/classify_product_list";
    }

    /**
     * 跳转到产品列表
     * @param optionalDo
     * @param model
     */
    @RequestMapping(value="/app/detail/skipProductDetail.do",method = RequestMethod.GET)
    public String skipProductDetail(TbMnMaterialOptionalDo optionalDo, Model model){
        log.info("跳转到产品列表,optionalDo:{}",optionalDo.toString());
        List<TbMnMaterialOptionalDo> optionalDos = taoBaoManager.getProductList(optionalDo);

        //获取商品详情
        TbMnProductDetailDo itemDetail = taoBaoManager.getProductDetail(optionalDo.getNumIid());

        String afterAmount = getAfterAmount(optionalDos.get(0));
        model.addAttribute("optionalDo",optionalDos.get(0));
        model.addAttribute("images",optionalDos.get(0).getSmallImages().split(","));
        model.addAttribute("itemDetail",itemDetail);
        model.addAttribute("afterAmount",afterAmount);
        return "page/product_detail";
    }

    private String getAfterAmount(TbMnMaterialOptionalDo optionalDo) {
        return String.valueOf(Double.valueOf(optionalDo.getZkFinalPrice())-Double.valueOf(optionalDo.getCouponAmount()));
    }
}
