package cn.mnquan.manager.impl;

import cn.mnquan.manager.ITaoBaoManager;
import cn.mnquan.mapper.TbMnCatItemMapper;
import cn.mnquan.mapper.TbMnMaterialOptionalMapper;
import cn.mnquan.model.*;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 描述
 * </p>
 * User: wangkecheng Date: 2018/9/30
 */
@Service
@Slf4j
public class TaoBaoManagerImpl implements ITaoBaoManager{

    @Autowired
    private TbMnMaterialOptionalMapper tbMnMaterialOptionalMapper;
    @Autowired
    private TbMnCatItemMapper tbMnCatItemMapper;

    /**
     * 获取首页元素列表
     * @param page
     * @return
     */
    public List<TbMnMaterialOptionalDo> getProductList(Page page) {
        PageHelper.startPage(page.getPageNo(),page.getPageSize());
        TbMnMaterialOptionalDoExample example = new TbMnMaterialOptionalDoExample();
        example.setOrderByClause("volume desc");
        List<TbMnMaterialOptionalDo> optionalDos = tbMnMaterialOptionalMapper.selectByExample(example);
        return optionalDos;
    }

    /**
     * 获取首页中心元素列表
     * @param page
     * @return
     */
    public List<TbMnMaterialOptionalDo> getCentreList(Page page) {
        List<TbMnMaterialOptionalDo> optionalDos = tbMnMaterialOptionalMapper.getCentreList();
        return optionalDos;
    }

    /**
     * 获取类目元素列表
     * @param catItemDo
     * @return
     */
    public List<TbMnCatItemDo> getCatList(TbMnCatItemDo catItemDo) {
        TbMnCatItemDoExample example = new TbMnCatItemDoExample();
        example.createCriteria().andCatIdEqualTo(catItemDo.getCatId());
        example.setOrderByClause("sort");
        List<TbMnCatItemDo> catItemDos = tbMnCatItemMapper.selectByExample(example);
        return catItemDos;
    }
}
