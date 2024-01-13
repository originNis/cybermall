package com.rybin.cybermall.controller;

import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.beans.entity.Orders;
import com.rybin.cybermall.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "订单处理", description = "处理订单提交保存等操作")
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    @Operation(summary = "提交订单", description = "前端提交以逗号分割的商品id以及订单，后端将进行保存")
    @PostMapping("/add")
    public ResultVO addOrder(String cids, @RequestBody Orders order) {
        return orderService.addOrder(cids, order);
    }
}
