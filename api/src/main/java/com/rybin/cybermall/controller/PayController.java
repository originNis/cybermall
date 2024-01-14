package com.rybin.cybermall.controller;

import com.rybin.cybermall.beans.VO.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@CrossOrigin
@RequestMapping("/pay")
public class PayController {

    @RequestMapping("/success")
    public void success() {

    }
}
