package com.example.superheltev3.services;

import com.example.superheltev3.model.Superhero;
import com.example.superheltev3.repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperheroService {
    private SuperheroRepository repository = new SuperheroRepository();
    public SuperheroService() {

    }

    public List<Superhero> getAllSuperheroes() {
        return repository.getSuperheroes();
    }

    public List<Superhero> getSuperhero(String name) {
        ArrayList<Superhero> allSuperheroes = (ArrayList<Superhero>) this.getAllSuperheroes();
        ArrayList<Superhero> superheroes = new ArrayList<>();
        for (Superhero superhero: allSuperheroes) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                superheroes.add(superhero);
            }
        }
        return superheroes;
    }
}
