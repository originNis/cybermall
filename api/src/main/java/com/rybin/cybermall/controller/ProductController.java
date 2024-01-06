package com.rybin.cybermall.controller;

import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.VO.ProductCommentsVO;
import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "商品评论", description = "返回商品评论信息")
    @GetMapping("/product-comments/{pid}")
    public ResultVO getCommentsByProductId(@PathVariable String pid,
                                           @RequestParam(value = "page") Integer page,
                                           @RequestParam(value = "size") Integer size) {
        return productService.getCommentsByProductId(pid,  page, size);
    }

    @Operation(summary = "商品评论统计", description = "返回商品评论统计信息，例如好评数、中评数、差评数等")
    @GetMapping("/product-statistics/{pid}")
    public ResultVO getCommentsStatisticsByProductId(@PathVariable String pid) {
        return productService.getCommentsStatisticsByProductId(pid);
    }
}
