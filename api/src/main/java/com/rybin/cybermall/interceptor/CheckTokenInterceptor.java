package com.rybin.cybermall.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.VO.ResultVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CheckTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if ("OPTIONS".equals(request.getMethod().toUpperCase())) {
            return true;
        }

        String token = request.getHeader("token");

        if (token == null) {
            doResponse(response, new ResultVO(ResponseStatus.FAIL, "请先登录", null));
        } else {
            // 按照该算法与密钥解析token
            JWTVerifier parser = JWT.require(Algorithm.HMAC256("cybermall")).build();

            try {
                // 如果解析成功则放行，反之则拒绝请求
                DecodedJWT decodedJWT = parser.verify(token);

                //System.out.println("获取购物车中商品列表:" + decodedJWT.getSubject());
                return true;
            } catch (TokenExpiredException e) {
                doResponse(response, new ResultVO(ResponseStatus.FAIL, "登录已过期", null));
            } catch (Exception e) {
                doResponse(response, new ResultVO(ResponseStatus.FAIL, "Token验证失败", null));
            }
        }

        return false;
    }

    // 当不放行请求时，由拦截器向前端发送响应消息
    private void doResponse(HttpServletResponse response, ResultVO result) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(new ObjectMapper().writeValueAsString(result));
    }
}
