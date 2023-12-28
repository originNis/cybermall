package com.rybin.cybermall.controller;

import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.service.CategoryService;
import com.rybin.cybermall.service.IndexService;
import com.rybin.cybermall.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "首页数据显示", description = "首页轮播图展示、用户信息展示等")
@RestController
@RequestMapping("/index")
@CrossOrigin
public class IndexController {
    @Resource
    IndexService indexService;
    @Resource
    CategoryService categoryService;
    @Resource
    ProductService productService;

    @Operation(summary = "首页轮播图展示", description = "返回在首页展示的轮播图的信息")
    @GetMapping("/indexImgs")
    public ResultVO listIndexImgs() {
        return indexService.listIndexImgs();
    }

    @Operation(summary = "首页分类展示", description = "返回在首页展示的分类的信息")
    @GetMapping("/listCategories")
    public ResultVO listCategories() {
        return categoryService.listCategories();
    }

    @Operation(summary = "新品推荐展示", description = "根据推荐算法返回推荐商品")
    @GetMapping("/list-recommendations")
    public ResultVO listRecommendations() {
        return productService.listRecommendations();
    }

    @Operation(summary = "按类别推荐商品", description = "按类别推荐商品")
    @GetMapping("/category-recommendations")
    public ResultVO listFirstLevelCategories() {
        return categoryService.listFirstLevelCategories();
    }
}
