package com.rybin.cybermall.controller;

import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.ResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "购物车管理", description = "购物车管理相关的接口说明")
@RestController
@RequestMapping("/shopcart")
@CrossOrigin
public class ShopcartController {

    @Operation(summary = "获取购物车中商品列表")
    @Parameter(name = "token", description = "用户登录后的token", required = true)
    @GetMapping("/list")
    public ResultVO listCarts(String token) {
        return new ResultVO(ResponseStatus.SUCCESS, "success", null);
    }
}
