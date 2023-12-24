package com.rybin.cybermall.controller;

import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.service.IndexService;
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

    @Operation(summary = "首页轮播图展示", description = "返回在首页展示的轮播图的信息")
    @GetMapping("/indexImgs")
    public ResultVO listIndexImgs() {
        return indexService.listIndexImgs();
    }
}
