package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.VO.ProductCommentsVO;
import com.rybin.cybermall.beans.entity.ProductComments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductCommentsDAO extends BaseMapper<ProductComments> {

    @Select("""
        SELECT
        product_comments.comm_id,
        product_comments.product_id,
        product_comments.product_name,
        product_comments.order_item_id,
        product_comments.is_anonymous,
        product_comments.comm_type,
        product_comments.comm_level,
        product_comments.comm_content,
        product_comments.comm_imgs,
        product_comments.sepc_name,
        product_comments.reply_status,
        product_comments.reply_content,
        product_comments.reply_time,
        product_comments.is_show,
        users.user_id,
        users.username,
        users.nickname,
        users.user_img
        FROM users INNER JOIN  product_comments ON users.user_id = product_comments.user_id
        WHERE product_comments.product_id = #{productId};
    """)
    public List<ProductCommentsVO> getCommentsByProductId(String productId);
}
