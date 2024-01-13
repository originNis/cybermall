package com.rybin.cybermall.beans.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计
 * </p>
 *
 * @author rybin
 * @since 2023-12-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ProductSku", description = "商品规格：每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计")
public class ProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * sku编号
     */
    @TableId
    private String skuId;

    /**
     * 商品id
     */
    private String productId;

    /**
     * sku名称
     */
    private String skuName;

    /**
     * sku图片
     */
    private String skuImg;

    /**
     * 属性组合（格式是p1:v1;p2:v2）
     */
    private String untitled;

    /**
     * 原价
     */
    private Double originalPrice;

    /**
     * 销售价格
     */
    private Double sellPrice;

    /**
     * 折扣力度
     */
    private Float discounts;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * sku状态(1启用，0禁用，-1删除)
     */
    private Integer status;


}
