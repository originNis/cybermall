package com.rybin.cybermall.service;

import com.rybin.cybermall.beans.VO.ShoppingCartVO;
import com.rybin.cybermall.beans.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    int addToShoppingCart(ShoppingCart shoppingCart);

    List<ShoppingCartVO> listShoppingCartByUserId(Integer userId);

    Integer updateCartNum(Integer cartId, Integer num);
}
