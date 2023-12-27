package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.entity.IndexImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.security.PublicKey;
import java.util.List;

@Mapper
public interface IndexImgDAO extends BaseMapper<IndexImg> {

    @Select("""
        SELECT img_id, img_url, img_bg_color, prod_id, category_id, index_type,
        seq, status, create_time, update_time
        FROM index_img
        WHERE status = 1
        ORDER BY seq;
    """)
    public List<IndexImg> listIndexImgs();
}
