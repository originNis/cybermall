package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.VO.CategoryVO;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryDAO extends BaseMapper<CategoryVO> {

    /*
    递归进行嵌套查询可以对n级类别进行查询
     */
    @Select("""
        SELECT category_id,
        category_name,
        category_level,
        parent_id,
        category_icon,
        category_slogan,
        category_pic,
        category_bg_color
        FROM category
        WHERE parent_id = #{parentId};
    """)
    @Results(
            @Result(column = "category_id", property = "subcategories", javaType = List.class,
                    many = @Many(select =  "com.rybin.cybermall.mapper.CategoryDAO.listCategories"))
    )
    public List<CategoryVO> listCategories(Integer parentId);
}
