package com.Springpro.Springpro.B2B.Controller;

import com.Springpro.Springpro.B2B.Entity.ProdOrd;
import com.Springpro.Springpro.B2B.Service.ProdOrdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/prodords")
public class ProdOrdController {
    private final ProdOrdService prodOrdService;

    public ProdOrdController(ProdOrdService prodOrdService) {
        this.prodOrdService = prodOrdService;
    }

    @PostMapping
    public ResponseEntity<ProdOrd> createProdOrd(@RequestBody ProdOrd prodOrd) {
        ProdOrd createdProdOrd = prodOrdService.createProdOrd(prodOrd);
        return ResponseEntity.ok(createdProdOrd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdOrd> updateProdOrd(@PathVariable("id") Long id, @RequestBody ProdOrd prodOrd) {
        ProdOrd updatedProdOrd = prodOrdService.updateProdOrd(id, prodOrd);
        return ResponseEntity.ok(updatedProdOrd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdOrd(@PathVariable("id") Long id) {
        prodOrdService.deleteProdOrd(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdOrd> getProdOrdById(@PathVariable("id") Long id) {
        ProdOrd prodOrd = prodOrdService.getProdOrdById(id);
        return ResponseEntity.ok(prodOrd);
    }
}