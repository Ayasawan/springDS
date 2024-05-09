package com.Springpro.Springpro.B2B.Controller;

import com.Springpro.Springpro.B2B.Entity.Orderr;
import com.Springpro.Springpro.B2B.Entity.ProdOrdd;
import com.Springpro.Springpro.B2B.Repository.ProdOrddRepo;
import com.Springpro.Springpro.B2B.Service.OrderrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderrController {
    @Autowired
    private OrderrService orderService;

    @Autowired
    private ProdOrddRepo prodOrdRepository;

    @PostMapping("/add")
    public String addOrder(@RequestBody Orderr order) {
        double totalPrice = 0.0;

        // استرداد الكمية والسعر من الجدول الوسيط ProdOrd
        List<ProdOrdd> prodOrds = prodOrdRepository.findByOrderId(order.getId());

        for (ProdOrdd prodOrd : prodOrds) {
            double quantity =order.getQuantity();
            double price = prodOrd.getProductt().getPrice();

            totalPrice += quantity * price;
        }

        order.setTotalPrice(totalPrice);

        Orderr savedOrder = orderService.saveOrder(order);

        return "تمت إضافة الطلبية بنجاح. السعر الإجمالي: " + savedOrder.getTotalPrice();
    }
    @GetMapping("/all")
    public List<Orderr> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Orderr> getOrderById(@PathVariable("id") Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @GetMapping("/company/{companyId}")
    public List<Orderr> getOrdersByCompanyId(@PathVariable("companyId") Long companyId) {
        return orderService.getOrdersByCompanyId(companyId);
    }
}