package com.rybin.cybermall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rybin.cybermall.beans.VO.CategoryVO;
import com.rybin.cybermall.beans.VO.ProductVO;
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
            @Result(column = "category_id",
                    property = "subcategories",
                    javaType = List.class,
                    many = @Many(select =  "com.rybin.cybermall.mapper.CategoryDAO.listCategories")
            )
    )
    public List<CategoryVO> listCategories(Integer parentId);

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
    @Results({
            @Result(column = "category_id",
                    property = "categoryId"
            ),
            @Result(column = "category_id",
                    property = "products",
                    javaType = List.class,
                    many = @Many(select = "com.rybin.cybermall.mapper.ProductDAO.listProductsByRootCategory")
            ),
            @Result(column = "category_id",
                    property = "subcategories",
                    javaType = List.class,
                    many = @Many(select =  "com.rybin.cybermall.mapper.CategoryDAO.listCategories")
            )
    })
    /* 在@Many中调用的关联查询方法有一个size参数，
    尽管@Result没有提供参数能让我们传递实参给它，但MyBatis会智能地从上下文推断应该传入什么参数，
    因此我们在该函数中也增加size参数，则调用该函数时传入的size参数同时会被智能地
    传递到关联查询方法中去。
     */
    public List<CategoryVO> listFirstLevelProducts(Integer size);
}
