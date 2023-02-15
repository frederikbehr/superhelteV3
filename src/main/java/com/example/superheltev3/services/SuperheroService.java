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

    public List<Superhero> createSuperhero(String id) {
        String[] data = id.split(",");
        try {
            Superhero createdSuperhero = new Superhero(data[0], data[1], data[2], Integer.parseInt(data[3]), Double.parseDouble(data[4]));
            repository.addSuperhero(createdSuperhero);
            return new ArrayList<>(List.of(createdSuperhero));
        } catch (Exception exception) {
            System.out.println(exception);
            return new ArrayList<>();
        }
    }

    public List<Superhero> editSuperhero(String id) {
        String[] data = id.split(",");
        Superhero superheroToEdit = new Superhero(data[0], data[1], data[2], Integer.parseInt(data[3]), Double.parseDouble(data[4]));
        ArrayList<Superhero> superheroes = (ArrayList<Superhero>) getAllSuperheroes();
        boolean superheroFound = false;
        for (Superhero superhero: superheroes) {
            if (superhero.getName().equalsIgnoreCase(superheroToEdit.getName())) {
                superheroFound = true;
                superheroes.remove(superhero);
                break;
            }
        }
        if (superheroFound) {
            repository.addSuperhero(superheroToEdit);
        }
        return new ArrayList<>(List.of(superheroToEdit));
    }

    public String deleteSuperhero(String id) {
        boolean deletedSuccessfully = repository.delete(id);
        return "Superhelten med navn: " + id + " er blevet slettet.";
    }
}
