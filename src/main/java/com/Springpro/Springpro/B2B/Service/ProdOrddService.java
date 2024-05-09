package com.Springpro.Springpro.B2B.Service;

import com.Springpro.Springpro.B2B.Entity.ProdOrdd;
import com.Springpro.Springpro.B2B.Repository.ProdOrddRepo;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProdOrddService {
    private final ProdOrddRepo prodOrdRepository;

    public ProdOrddService(ProdOrddRepo prodOrdRepository) {
        this.prodOrdRepository = prodOrdRepository;
    }

    public ProdOrdd createProdOrd(ProdOrdd prodOrd) {
        return prodOrdRepository.save(prodOrd);
    }

    public ProdOrdd updateProdOrd(Long id, ProdOrdd prodOrd) {
        ProdOrdd existingProdOrd = getProdOrdById(id);
        existingProdOrd.setOrder(prodOrd.getOrder());
        existingProdOrd.setProduct(prodOrd.getProduct());
        return prodOrdRepository.save(existingProdOrd);
    }

    public void deleteProdOrd(Long id) {
        prodOrdRepository.deleteById(id);
    }

    public ProdOrdd getProdOrdById(Long id) {
        return prodOrdRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ProdOrd not found with id: " + id));
    }


}