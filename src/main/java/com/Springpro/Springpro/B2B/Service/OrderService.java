package com.Springpro.Springpro.B2B.Service;

import com.Springpro.Springpro.B2B.Entity.Order;
import com.Springpro.Springpro.B2B.Entity.ProdOrd;
import com.Springpro.Springpro.B2B.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<Order> getOrdersByCompanyId(Long companyId) {
        return orderRepository.findByCompanyId(companyId);
    }



}