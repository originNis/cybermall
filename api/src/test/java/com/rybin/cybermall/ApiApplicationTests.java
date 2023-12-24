package com.rybin.cybermall;

import com.rybin.cybermall.beans.Item;
import com.rybin.cybermall.beans.VO.CategoryVO;
import com.rybin.cybermall.mapper.CategoryDAO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/*
@SpringBootTest需要指定启动类，尽管在同一个模块中默认使用当前模块的启动类，
但如果在模块结构复杂、启动类在别的模块中的情景下，就需要显式指定启动类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class ApiApplicationTests {
    @Resource
    CategoryDAO categoryDAO;

    @Test
    public void testCategoryDAO() {
        List<CategoryVO> categoryVOS = categoryDAO.listCategories();

        for (var c1 : categoryVOS) {
            System.out.println(c1);
            for (var c2 : c1.getSubcategories()) {
                System.out.println("\t" + c2);
                for( var c3: c2.getSubcategories()) {
                    System.out.println("\t\t" + c3);
                }
            }
        }
    }
}
