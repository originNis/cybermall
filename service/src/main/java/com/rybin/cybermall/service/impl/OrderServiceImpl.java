package com.rybin.cybermall.service.impl;

import com.rybin.cybermall.beans.ResponseStatus;
import com.rybin.cybermall.beans.VO.ResultVO;
import com.rybin.cybermall.beans.VO.ShoppingCartVO;
import com.rybin.cybermall.beans.entity.OrderItem;
import com.rybin.cybermall.beans.entity.Orders;
import com.rybin.cybermall.beans.entity.ProductSku;
import com.rybin.cybermall.mapper.OrderItemDAO;
import com.rybin.cybermall.mapper.OrdersDAO;
import com.rybin.cybermall.mapper.ProductSkuDAO;
import com.rybin.cybermall.mapper.ShoppingCartDAO;
import com.rybin.cybermall.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    ShoppingCartDAO shoppingCartDAO;
    @Resource
    OrdersDAO ordersDAO;
    @Resource
    OrderItemDAO orderItemDAO;
    @Resource
    ProductSkuDAO productSkuDAO;

    // 多个数据库操作，需要使用事务
    @Override
    @Transactional
    public Map<String, String> addOrder(String cids, Orders order) throws SQLException {
        // 返回的map
        Map<String, String> returnMap = new HashMap<>();
        /************ 插入订单表 **********************************/
        // 主键为varchar，需要自己设置主键
        order.setOrderId(UUID.randomUUID().toString().replace("-", ""));
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());

        List<Integer> cidsList = new ArrayList<>();
        String[] split = cids.split(",");
        for (String str : split) {
            cidsList.add(Integer.parseInt(str));
        }
        List<ShoppingCartVO> shoppingCartVOS = shoppingCartDAO.selectShoppingCartByListCartId(cidsList);

        String untitled = "";
        for (int i = 0; i < shoppingCartVOS.size(); ++i) {
            untitled += shoppingCartVOS.get(i).getProductName();
            if (i < shoppingCartVOS.size() - 1) untitled += ",";
        }
        order.setUntitled(untitled);

         int res1 = ordersDAO.insert(order);

        /************ 订单表插入成功则向订单快照表插入快照 **********************************/
        if (res1 > 0) {
            returnMap.put("orderId", order.getOrderId());
            returnMap.put("productsName", untitled);
            returnMap.put("amount", order.getActualAmount() + "");

            for (ShoppingCartVO sc : shoppingCartVOS) {
                OrderItem orderItem = new OrderItem();
                orderItem.setItemId(System.currentTimeMillis() + "");
                orderItem.setOrderId(order.getOrderId());
                orderItem.setProductId(sc.getProductId());
                orderItem.setProductName(sc.getProductName());
                orderItem.setProductImg(sc.getProductImg());
                orderItem.setSkuId(sc.getSkuId());
                orderItem.setSkuName(sc.getSkuName());
                orderItem.setProductPrice(sc.getSellPrice());
                orderItem.setBuyCounts(Integer.parseInt(sc.getCartNum()));
                orderItem.setTotalAmount(orderItem.getProductPrice() * orderItem.getBuyCounts());
                orderItem.setBasketDate(new Date());
                orderItem.setIsComment(0);

                if (orderItemDAO.insert(orderItem) <= 0) {
                    // 插入快照失败
                    return null;
                }

                // 更新库存
                ProductSku productSku = new ProductSku();
                productSku.setSkuId(sc.getSkuId());
                productSku.setStock(Integer.parseInt(sc.getSkuStock()) - Integer.parseInt(sc.getCartNum()));
                if (productSkuDAO.updateById(productSku) <= 0) {
                    return null;
                }

                // 删除该购物车商品
                shoppingCartDAO.deleteById(sc.getCartId());
            }

            return returnMap;
        } else {
            return null;
        }
    }
}
