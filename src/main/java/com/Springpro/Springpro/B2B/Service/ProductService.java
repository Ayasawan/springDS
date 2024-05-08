package com.Springpro.Springpro.B2B.Service;

import com.Springpro.Springpro.B2B.Entity.Product;
import com.Springpro.Springpro.B2B.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product saveDetails(Product product) {
        return productRepo.save(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }
}