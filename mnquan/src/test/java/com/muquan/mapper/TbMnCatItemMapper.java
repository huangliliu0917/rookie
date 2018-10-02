package com.muquan.mapper;

import com.muquan.model.TbMnCatItemDo;
import com.muquan.model.TbMnCatItemDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMnCatItemMapper {
    long countByExample(TbMnCatItemDoExample example);

    int insert(TbMnCatItemDo record);

    int insertSelective(TbMnCatItemDo record);

    List<TbMnCatItemDo> selectByExample(TbMnCatItemDoExample example);

    int updateByExampleSelective(@Param("record") TbMnCatItemDo record, @Param("example") TbMnCatItemDoExample example);

    int updateByExample(@Param("record") TbMnCatItemDo record, @Param("example") TbMnCatItemDoExample example);
}