package com.rybin.cybermall.beans.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 商品评价 
 * </p>
 *
 * @author rybin
 * @since 2023-12-19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ProductComments", description = "商品相关评论")
public class ProductComments implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String commId;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 订单项(商品快照)ID 可为空
     */
    private String orderItemId;

    /**
     * 评论用户id 用户名须脱敏
     */
    private String userId;

    /**
     * 是否匿名（1:是，0:否）
     */
    private Integer isAnonymous;

    /**
     * 评价类型（1好评，0中评，-1差评）
     */
    private Integer commType;

    /**
     * 评价等级 1：好评 2：中评 3：差评
     */
    private Integer commLevel;

    /**
     * 评价内容
     */
    private String commContent;

    /**
     * 评价晒图(JSON {img1:url1,img2:url2}  )
     */
    private String commImgs;

    /**
     * 评价时间 可为空
     */
    private Date sepcName;

    /**
     * 是否回复（0:未回复，1:已回复）
     */
    private Integer replyStatus;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 回复时间
     */
    private Date replyTime;

    /**
     * 是否显示（1:是，0:否）
     */
    private Integer isShow;


}
