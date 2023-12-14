package com.rybin.cybermall;

import com.rybin.cybermall.beans.Item;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
@SpringBootTest需要指定启动类，尽管在同一个模块中默认使用当前模块的启动类，
但如果在模块结构复杂、启动类在别的模块中的情景下，就需要显式指定启动类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class ApiApplicationTests {
    @Resource
    SelfMapper mapper;

    @Test
    void testMybatisModule() {
        Item item = mapper.getItemById(1);
        System.out.println(item);
    }

}
