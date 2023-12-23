package com.rybin.cybermall.beans.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 轮播图 
 * </p>
 *
 * @author rybin
 * @since 2023-12-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// 该注解代替了swagger的@ApiModel
@Schema(name = "IndexImg", description = "存放首页轮播图的信息")
public class IndexImg implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String imgId;

    /**
     * 图片 图片地址
     */
    private String imgUrl;

    /**
     * 背景色 背景颜色
     */
    private String imgBgColor;

    /**
     * 商品id 商品id
     */
    private String prodId;

    /**
     * 商品分类id 商品分类id
     */
    private String categoryId;

    /**
     * 轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类
     */
    private Integer indexType;

    /**
     * 轮播图展示顺序 轮播图展示顺序，从小到大
     */
    private Integer seq;

    /**
     * 是否展示:1表示正常显示，0表示下线 是否展示，1：展示    0：不展示
     */
    private Integer status;

    /**
     * 创建时间 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间 更新
     */
    private LocalDateTime updateTime;


}
