package com.rybin.cybermall.controller;

import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.beans.entity.ShoppingCart;
import com.rybin.cybermall.service.ShoppingCartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "购物车管理", description = "购物车管理相关的接口说明")
@RestController
@RequestMapping("/shopcart")
@CrossOrigin
public class ShoppingCartController {
    @Resource
    ShoppingCartService shoppingCartService;

    @Operation(summary = "获取购物车中商品列表")
    @Parameter(name = "token", description = "用户登录后的token", required = true)
    @GetMapping("/list")
    public ResultVO listCarts(String token) {
        return new ResultVO(ResponseStatus.SUCCESS, "success", null);
    }

    @Operation(summary = "购物车添加商品")
    @PostMapping("/add")
    public ResultVO addToShoppingCart(@RequestBody ShoppingCart shoppingCart, @RequestHeader("token") String token) {
        shoppingCartService.addToShoppingCart(shoppingCart);
        return new ResultVO(ResponseStatus.SUCCESS, "success", null);
    }
}
