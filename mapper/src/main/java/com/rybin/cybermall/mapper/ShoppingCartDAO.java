package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.VO.ShoppingCartVO;
import com.rybin.cybermall.beans.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingCartDAO extends BaseMapper<ShoppingCart> {

    @Select("""
        SELECT a.cart_id,
        a.product_id,
        a.sku_id,
        a.user_id,
        a.cart_num,
        a.cart_time,
        a.product_price,
        a.sku_props,
        b.product_name,
        c.url,
        s.original_price,
        s.sell_price
        FROM shopping_cart a
        INNER JOIN product b
        INNER JOIN product_img c
        INNER JOIN product_sku s
        ON a.product_id = b.product_id AND b.product_id = c.item_id AND b.product_id = s.product_id
        WHERE a.user_id = #{userId} AND c.is_main = 1
    """)
    @Result(column = "product_name", property = "productName")
    @Result(column = "url", property = "productImg")
    List<ShoppingCartVO> selectShoppingCartByUserId(Integer userId);

    @Update("""
        UPDATE shopping_cart
        SET cart_num = #{cartNum}
        WHERE cart_id = #{cartId}
    """)
    Integer updateCartNum(Integer cartId, Integer cartNum);
}
