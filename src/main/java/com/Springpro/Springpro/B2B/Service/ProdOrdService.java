package com.Springpro.Springpro.B2B.Service;

import com.Springpro.Springpro.B2B.Entity.ProdOrd;
import com.Springpro.Springpro.B2B.Repository.ProdOrdRepo;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProdOrdService {
    private final ProdOrdRepo prodOrdRepository;

    public ProdOrdService(ProdOrdRepo prodOrdRepository) {
        this.prodOrdRepository = prodOrdRepository;
    }

    public ProdOrd createProdOrd(ProdOrd prodOrd) {
        return prodOrdRepository.save(prodOrd);
    }

    public ProdOrd updateProdOrd(Long id, ProdOrd prodOrd) {
        ProdOrd existingProdOrd = getProdOrdById(id);
        existingProdOrd.setOrder(prodOrd.getOrder());
        existingProdOrd.setProduct(prodOrd.getProduct());
        return prodOrdRepository.save(existingProdOrd);
    }

    public void deleteProdOrd(Long id) {
        prodOrdRepository.deleteById(id);
    }

    public ProdOrd getProdOrdById(Long id) {
        return prodOrdRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ProdOrd not found with id: " + id));
    }
}