package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.VO.ProductVO;
import com.rybin.cybermall.beans.entity.Product;
import com.rybin.cybermall.beans.entity.ProductImg;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductDAO extends BaseMapper<Product> {

    @Select("""
        SELECT product_id,
        product_name,
        category_id,
        root_category_id,
        content,
        sold_num,
        product_status,
        create_time,
        update_time
        FROM product
        ORDER BY create_time DESC
        LIMIT 0, #{size}
    """)
    @Results({
            @Result(column = "product_id",
                    property = "imgs",
                    many = @Many(select = "com.rybin.cybermall.mapper.ProductImgDAO.listImgs")
            ),
            @Result(column = "product_id",
                    property = "productId"
            )
    })
    public List<ProductVO> listProductsOrderByDate(Integer size);

    @Select("""
        SELECT product_id,
        product_name,
        category_id,
        root_category_id,
        content,
        sold_num,
        product_status,
        create_time,
        update_time
        FROM product
        WHERE root_category_id = #{categoryId}
        ORDER BY sold_num
        LIMIT 0, #{size}
    """)
    @Results({
            @Result(column = "product_id",
                    property = "imgs",
                    many = @Many(select = "com.rybin.cybermall.mapper.ProductImgDAO.listImgs")
            ),
            @Result(column = "product_id",
                    property = "productId"
            )
    })
    public List<ProductVO> listProductsByRootCategory(Integer categoryId, Integer size);
}
