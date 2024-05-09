package com.Springpro.Springpro.B2B.Controller;

import com.Springpro.Springpro.B2B.Entity.Productt;
import com.Springpro.Springpro.B2B.Service.ProducttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProducttController {

    @Autowired
    private ProducttService productService;

    @PostMapping("/addProduct")
    public Productt addProduct(@RequestBody Productt product) {
        return productService.saveDetails(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/updateProduct")
    public Productt updateProduct(@RequestBody Productt product) {
        productService.updateProduct(product);
        return product;
    }

    @GetMapping("/getAllProducts")
    public List<Productt> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/getProductById/{id}")
    public Optional<Productt> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }
}