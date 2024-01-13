package com.rybin.cybermall.beans.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 为购物车功能新增了productName和productImg属性
 *
 * @author rybin
 * @since 2023-12-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShoppingCartVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "cart_id", type = IdType.AUTO)
    private Integer cartId;

    /**
     * 商品ID
     */
    private String productId;

    /**
     * skuID
     */
    private String skuId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 购物车商品数量
     */
    private String cartNum;

    /**
     * 添加购物车时间
     */
    private String cartTime;

    /**
     * 添加购物车时商品价格
     */
    private Double productPrice;

    /**
     * 选择的套餐的属性
     */
    private String skuProps;


    private String productName;
    private String productImg;
    private Double originalPrice;
    private Double sellPrice;
    private String skuName;
    private String skuStock;
}
