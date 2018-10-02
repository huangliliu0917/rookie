package cn.mnquan.manager;

import cn.mnquan.model.Page;
import cn.mnquan.model.TbMnCatItemDo;
import cn.mnquan.model.TbMnMaterialOptionalDo;

import java.util.List;

/**
 * <p>
 * 描述
 * </p>
 * User: wangkecheng Date: 2018/9/30
 */
public interface ITaoBaoManager {
    List<TbMnMaterialOptionalDo> getProductList(Page page);

    List<TbMnMaterialOptionalDo> getCentreList(Page page);

    List<TbMnCatItemDo> getCatList(TbMnCatItemDo catItemDo);
}
