package com.rybin.cybermall.controller;

import com.github.wxpay.sdk.WXPay;
import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.beans.entity.Orders;
import com.rybin.cybermall.config.MyPayConfig;
import com.rybin.cybermall.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Tag(name = "订单处理", description = "处理订单提交保存等操作")
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    @Operation(summary = "提交订单", description = "前端提交以逗号分割的商品id以及订单，后端保存并生成付款链接")
    @PostMapping("/add")
    public ResultVO addOrder(String cids, @RequestBody Orders order) {
        ResultVO resultVO = null;
        try {
            Map<String, String> resMap = orderService.addOrder(cids, order);
            if (resMap == null) {throw new Exception(); }

            String orderId = resMap.get("orderId");
            String productsName = resMap.get("productsName");
            double amount = Double.parseDouble(resMap.get("amount")) * 100;

            WXPay wxPay = new WXPay(new MyPayConfig());
            Map<String, String> param = new HashMap<>();
            param.put("body", productsName);
            param.put("out_trade_no", orderId);
            param.put("trade_type", "NATIVE");
            param.put("free_type", "CNY");
            param.put("total_fee", (int)amount + "");
            param.put("notify_url", "/pay/success");
            Map<String, String> returnMap = wxPay.unifiedOrder(param);

            resMap.put("payUrl", returnMap.get("code_url"));
            resultVO = new ResultVO(ResponseStatus.SUCCESS, "订单提交成功", resMap);
        } catch (SQLException e) {
            resultVO = new ResultVO(ResponseStatus.FAIL, "提交订单失败", null);
        } catch (Exception e) {
            resultVO = new ResultVO(ResponseStatus.FAIL, "生成支付失败", null);
        }
        return resultVO;
    }
}
