package com.rybin.cybermall.controller;

import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.beans.VO.ShoppingCartVO;
import com.rybin.cybermall.beans.entity.ShoppingCart;
import com.rybin.cybermall.service.ShoppingCartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "购物车管理", description = "购物车管理相关的接口说明")
@RestController
@RequestMapping("/shopcart")
@CrossOrigin
public class ShoppingCartController {
    @Resource
    ShoppingCartService shoppingCartService;

    @Operation(summary = "购物车添加商品")
    @PostMapping("/add")
    public ResultVO addToShoppingCart(@RequestBody ShoppingCart shoppingCart, @RequestHeader("token") String token) {
        shoppingCartService.addToShoppingCart(shoppingCart);
        return new ResultVO(ResponseStatus.SUCCESS, "success", null);
    }

    @Operation(summary = "获取用户购物车中的商品列表")
    @GetMapping("/list")
    public ResultVO listShoppingCart(Integer userId) {
        List<ShoppingCartVO> shoppingCartVOS = shoppingCartService.listShoppingCartByUserId(userId);
        return new ResultVO(ResponseStatus.SUCCESS, "success", shoppingCartVOS);
    }

    @Operation(summary = "更改购物车中商品的数量")
    @PutMapping("/update/{cid}/{num}")
    public ResultVO updateCartNum(@PathVariable("cid") Integer cartId, @PathVariable("num") Integer cartNum) {
        int res = shoppingCartService.updateCartNum(cartId, cartNum);
        if (res > 0) {
            return new ResultVO(ResponseStatus.SUCCESS, "success", null);
        } else {
            return new ResultVO(ResponseStatus.FAIL, "fail", null);
        }
    }

    @Operation(summary = "批量查询购物车商品", description = "用于购物车选择商品结算时进行查询")
    @Parameter(name = "cids", description = "字符串形式传入购物车商品id列表，多个cid使用逗号分隔", required = true)
    @GetMapping("/listByCids")
    public ResultVO selectShoppingCartByListCartId(String cids, @RequestHeader("token") String token) {
        List<ShoppingCartVO> list = shoppingCartService.selectShoppingCartByListCartId(cids);
        return new ResultVO(ResponseStatus.SUCCESS, "success", list);
    }
}
