package com.Springpro.Springpro.B2B.Controller;

import com.Springpro.Springpro.B2B.Entity.Reproducer;
import com.Springpro.Springpro.B2B.Service.ReproducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ReproducerController {

    @Autowired
    private ReproducerService reproducerService;

    @PostMapping("/addReproducer")
    public Reproducer addReproducer(@RequestBody Reproducer reproducer) {
        return reproducerService.saveReproducer(reproducer);
    }

    @DeleteMapping("/deleteReproducer/{id}")
    public void deleteReproducer(@PathVariable int id) {
        reproducerService.deleteReproducer(id);
    }

    @PutMapping("/updateReproducer")
    public Reproducer updateReproducer(@RequestBody Reproducer reproducer) {
        reproducerService.updateReproducer(reproducer);
        return reproducer;
    }

    @GetMapping("/getAllReproducers")
    public List<Reproducer> getAllReproducers() {
        return reproducerService.getAllReproducers();
    }

    @GetMapping("/getReproducerById/{id}")
    public Optional<Reproducer> getReproducerById(@PathVariable int id) {
        return reproducerService.getReproducerById(id);
    }
}