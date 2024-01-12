package com.rybin.cybermall.controller;

import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.service.UserAddrService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "收货地址管理", description =  "在提交订单等功能中需要使用收货地址")
@RestController
@CrossOrigin
@RequestMapping("/userAddr")
public class UserAddrController {
    @Resource
    UserAddrService userAddrService;

    @Operation(summary = "获取用户收货地址列表")
    @GetMapping("/list")
    public ResultVO listUserAddr(Integer userId) {
        return userAddrService.listUserAddrByUserId(userId);
    }
}
