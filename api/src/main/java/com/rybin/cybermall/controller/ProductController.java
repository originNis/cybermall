package com.rybin.cybermall.controller;

import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "商品详情页", description = "展示商品信息、用户评价、商品参数等")
@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Resource
    ProductService productService;

    @Operation(summary = "商品详情", description = "返回商品信息、相关图片、商品规格等")
    @GetMapping("/detail/{pid}")
    public ResultVO getProductDetail(@PathVariable("pid") String pid) {
        return productService.getProductInfoById(pid);
    }

    @Operation(summary = "商品参数", description = "返回商品参数信息，例如生产地、使用方式等")
    @GetMapping("/param/{pid}")
    public ResultVO getProductParams(@PathVariable("pid") String pid) {
        return productService.getProductParams(pid);
    }
}
