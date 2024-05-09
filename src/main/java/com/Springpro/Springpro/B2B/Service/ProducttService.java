package com.Springpro.Springpro.B2B.Service;

import com.Springpro.Springpro.B2B.Entity.Productt;
import com.Springpro.Springpro.B2B.Repository.ProducttRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducttService {

    @Autowired
    private ProducttRepo productRepo;

    public Productt saveDetails(Productt product) {
        return productRepo.save(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public Productt updateProduct(Productt product) {
        return productRepo.save(product);
    }

    public List<Productt> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Productt> getProductById(int id) {
        return productRepo.findById(id);
    }
}