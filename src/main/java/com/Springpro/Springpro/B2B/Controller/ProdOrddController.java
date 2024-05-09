package com.Springpro.Springpro.B2B.Controller;

import com.Springpro.Springpro.B2B.Entity.ProdOrdd;
import com.Springpro.Springpro.B2B.Service.ProdOrddService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prodords")
public class ProdOrddController {
    private final ProdOrddService prodOrdService;

    public ProdOrddController(ProdOrddService prodOrdService) {
        this.prodOrdService = prodOrdService;
    }

    @PostMapping
    public ResponseEntity<ProdOrdd> createProdOrd(@RequestBody ProdOrdd prodOrd) {
        ProdOrdd createdProdOrd = prodOrdService.createProdOrd(prodOrd);
        return ResponseEntity.ok(createdProdOrd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdOrdd> updateProdOrd(@PathVariable("id") Long id, @RequestBody ProdOrdd prodOrd) {
        ProdOrdd updatedProdOrd = prodOrdService.updateProdOrd(id, prodOrd);
        return ResponseEntity.ok(updatedProdOrd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdOrd(@PathVariable("id") Long id) {
        prodOrdService.deleteProdOrd(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdOrdd> getProdOrdById(@PathVariable("id") Long id) {
        ProdOrdd prodOrd = prodOrdService.getProdOrdById(id);
        return ResponseEntity.ok(prodOrd);
    }
}