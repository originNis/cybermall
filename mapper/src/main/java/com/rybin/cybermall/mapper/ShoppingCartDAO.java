package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.VO.ShoppingCartVO;
import com.rybin.cybermall.beans.entity.ShoppingCart;
import org.apache.ibatis.annotations.*;

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
        s.sell_price,
        s.stock,
        s.sku_name
        FROM shopping_cart a
        INNER JOIN product b
        INNER JOIN product_img c
        INNER JOIN product_sku s
        ON a.product_id = b.product_id AND b.product_id = c.item_id AND a.sku_id = s.sku_id
        WHERE a.user_id = #{userId} AND c.is_main = 1
    """)
    @Result(column = "product_name", property = "productName")
    @Result(column = "url", property = "productImg")
    @Result(column = "stock", property = "skuStock")
    List<ShoppingCartVO> selectShoppingCartByUserId(Integer userId);

    @Update("""
        UPDATE shopping_cart
        SET cart_num = #{cartNum}
        WHERE cart_id = #{cartId}
    """)
    Integer updateCartNum(Integer cartId, Integer cartNum);

    @Select("""
        <script>
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
            s.sell_price,
            s.stock,
            s.sku_name
            FROM shopping_cart a
            INNER JOIN product b
            INNER JOIN product_img c
            INNER JOIN product_sku s
            ON a.product_id = b.product_id AND b.product_id = c.item_id AND a.sku_id = s.sku_id
            WHERE c.is_main = 1 AND a.cart_id IN
            <foreach collection = 'cids' item = 'cid' open = '(' separator = ',' close = ')'>
                #{cid}
            </foreach>
        </script>
    """)
    @Result(column = "url", property = "productImg")
    @Result(column = "stock", property = "skuStock")
    List<ShoppingCartVO> selectShoppingCartByListCartId(@Param("cids") List<Integer> cids);
}
