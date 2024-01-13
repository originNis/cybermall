package com.rybin.cybermall.beans.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.*;

/**
 * <p>
 * 订单项/快照 
 * </p>
 *
 * @author rybin
 * @since 2023-12-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单项ID
     */
    private String itemId;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品图片
     */
    private String productImg;

    /**
     * skuID
     */
    private String skuId;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * 商品价格
     */
    private Double productPrice;

    /**
     * 购买数量
     */
    private Integer buyCounts;

    /**
     * 商品总金额
     */
    private Double totalAmount;

    /**
     * 加入购物车时间
     */
    private Date basketDate;

    /**
     * 购买时间
     */
    private Date buyTime;

    /**
     * 评论状态： 0 未评价  1 已评价
     */
    private Integer isComment;


}
