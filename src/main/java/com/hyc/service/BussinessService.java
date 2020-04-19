package com.hyc.service;

import com.hyc.dao.*;
import com.hyc.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BussinessService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserAddressMapper addressMapper;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderItemMapper orderItemMapper;
    @Resource
    private ProductMapper productMapper;

    @Transactional
    public void saveAll(User user, UserAddress address, Order order, OrderItem orderItem) {
        userMapper.insert(user);

        address.setUserId(user.getUserId());
        addressMapper.insert(address);

        order.setUserId(user.getUserId());
        orderMapper.insert(order);

        orderItem.setOrderId(order.getOrderId());
        orderItem.setUserId(user.getUserId());
        orderItemMapper.insert(orderItem);
    }

    @Transactional
    public void saveProduct(Product product) {
        productMapper.insert(product);
    }

    @Transactional
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    public Map<String, Object> findAll() {
        Map<String, Object> result = new HashMap<>();

        Long userId = 594099642262884355L;
        User user = userMapper.selectById(userId);
        result.put("user", user);

        UserAddress address = addressMapper.selectById(userId);
        result.put("address", address);

        Order order = orderMapper.selectById(userId);
        result.put("order", order);

        OrderItem orderItem = orderItemMapper.selectById(order.getOrderId());
        result.put("orderItem", orderItem);

        return result;
    }

    public User selectById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> selectByAge(int age) {
        return userMapper.selectByAge(age);
    }

}