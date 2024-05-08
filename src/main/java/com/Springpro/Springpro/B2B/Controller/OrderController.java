package com.Springpro.Springpro.B2B.Controller;


import com.Springpro.Springpro.B2B.Entity.Order;
import com.Springpro.Springpro.B2B.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable("id") Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @GetMapping("/{companyId}/orders")
    public List<Order> getOrdersByCompanyId(@PathVariable("companyId") Long companyId) {
        return orderService.getOrdersByCompanyId(companyId);
    }
}