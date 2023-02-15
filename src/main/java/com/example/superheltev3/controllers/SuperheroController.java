package com.example.superheltev3.controllers;

import com.example.superheltev3.model.Superhero;
import com.example.superheltev3.services.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class SuperheroController {
    SuperheroService superheroService = new SuperheroService();

    @GetMapping("/")
    public ResponseEntity<List<Superhero>> getAllSuperheroes() {
        return new ResponseEntity<>(superheroService.getAllSuperheroes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Superhero>> getSuperhero(@PathVariable String id) {
        return new ResponseEntity<>(superheroService.getSuperhero(id), HttpStatus.OK);
    }
    @GetMapping("/opret")
    public ResponseEntity<List<Superhero>> createSuperhero(@RequestParam String id) {
        return new ResponseEntity<>(superheroService.createSuperhero(id), HttpStatus.OK);
    }

    @GetMapping("velkommen/{id}")
    public ResponseEntity<String> welcome(@PathVariable int id) {
        String message = "Semesteret eksisterer ikke.";
        if (id <= 5 && id >= 0) {
            message = "Velkommen til KEA " + id + ". semester!";
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
