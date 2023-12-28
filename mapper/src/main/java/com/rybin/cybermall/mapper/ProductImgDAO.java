package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.entity.ProductImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductImgDAO extends BaseMapper<ProductImg> {
    @Select("""
        SELECT id,
        item_id,
        url,
        sort,
        is_main,
        created_time,
        updated_time
        FROM product_img
        WHERE item_id = #{itemId}
    """)
    public List<ProductImg> listImgs(Integer itemId);
}
