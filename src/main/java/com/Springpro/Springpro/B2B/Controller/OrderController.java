package com.Springpro.Springpro.B2B.Controller;

import com.Springpro.Springpro.B2B.Entity.Order;
import com.Springpro.Springpro.B2B.Entity.ProdOrd;
import com.Springpro.Springpro.B2B.Repository.ProdOrdRepo;
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

    @Autowired
    private ProdOrdRepo prodOrdRepository;

    @PostMapping("/add")
    public String addOrder(@RequestBody Order order) {
        double totalPrice = 0.0;

        // استرداد الكمية والسعر من الجدول الوسيط ProdOrd
        List<ProdOrd> prodOrds = prodOrdRepository.findByOrderId(order.getId());

        for (ProdOrd prodOrd : prodOrds) {
            double quantity =order.getQuantity();
            double price = prodOrd.getProduct().getPrice();

            totalPrice += quantity * price;
        }

        order.setTotalPrice(totalPrice);

        Order savedOrder = orderService.saveOrder(order);

        return "تمت إضافة الطلبية بنجاح. السعر الإجمالي: " + savedOrder.getTotalPrice();
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

    @GetMapping("/company/{companyId}")
    public List<Order> getOrdersByCompanyId(@PathVariable("companyId") Long companyId) {
        return orderService.getOrdersByCompanyId(companyId);
    }
}