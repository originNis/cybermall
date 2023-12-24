package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.VO.CategoryVO;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryDAO extends BaseMapper<CategoryVO> {

    /*
    嵌套映射三级商品分类
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
        WHERE category_level = 1;
    """)
    @Results(
            @Result(column = "category_id", property = "subcategories", javaType = List.class,
                    many = @Many(select =  "com.rybin.cybermall.mapper.CategoryDAO.listSecondLevelCategories"))
    )
    public List<CategoryVO> listCategories();

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
                    many = @Many(select =  "com.rybin.cybermall.mapper.CategoryDAO.listThirdLevelCategories"))
    )
    public List<CategoryVO> listSecondLevelCategories(Integer parentId);

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
    public List<CategoryVO> listThirdLevelCategories(Integer parentId);
}
