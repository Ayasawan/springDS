package com.Springpro.Springpro.B2B.Service;

import com.Springpro.Springpro.B2B.Entity.Orderr;
import com.Springpro.Springpro.B2B.Repository.OrderrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderrService {
    @Autowired
    private OrderrRepo orderRepository;

    public Orderr saveOrder(Orderr order) {
        return orderRepository.save(order);
    }

    public List<Orderr> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Orderr> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<Orderr> getOrdersByCompanyId(Long companyId) {
        return orderRepository.findByCompanyId(companyId);
    }



}