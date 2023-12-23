package com.rybin.cybermall.controller;

import com.rybin.cybermall.beans.ResultVO;
import com.rybin.cybermall.beans.entity.Users;
import com.rybin.cybermall.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/* OpenAPI的@Tag注解替代了Swagger的@Api注解，
   name是这个控制器的名称，
   description是这个控制器的描述，在ui中小以字显示在name右侧。

   OpenAPI的注解说明可以参考如下文章：
   https://blog.csdn.net/yuanye01/article/details/132062665
 */
@Tag(name = "用户管理", description = "用户管理相关的接口说明")
@RestController
@RequestMapping("/user")
// 解决跨域问题
@CrossOrigin
public class UserController {

    @Resource
    UserService userService;

    /*
    OpenAPI的@Operation注解替代了Swagger的@ApiOperation注解，
    summary是接口的说明，在ui显示在请求路径旁，
    description是接口的详细说明，显示在接口的展开窗中。
     */
    @Operation(summary = "登录", description = "用户登录接口")
    /*
    OpenAPI的@Parameters注解替代了Swagger的@ApiImplicitParams注解，
    其中的@Parameter的name是参数名（即控制方法的形参名），
    description是参数的说明，在ui显示在参数名旁，
    required是参数是否必填。
     */
    @Parameters({
            @Parameter(name = "username", description = "用户登录账号", required = true),
            @Parameter(name = "password", description = "用户登录密码", required = true)
    })
    @GetMapping(value = "/login")
    public ResultVO login(String username, String password) {
        return userService.userLogin(username, password);
    }

    @Parameters({
            @Parameter(name = "username", description = "用户注册账号", required = true),
            @Parameter(name = "password", description = "用户注册密码", required = true)
    })
    @PostMapping(value = "/regist")
    /*
    @RequestBody只能修饰一个形参，用来接收一个JSON字符串，
    而@RequestParam可以修饰多个形参，用来接收一个或多个URL参数
     */
    public ResultVO regist(@RequestBody Users user) {
        return userService.userRegist(user.getUsername(), user.getPassword());
    }
}
