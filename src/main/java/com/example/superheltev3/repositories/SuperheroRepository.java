package com.example.superheltev3.repositories;

import com.example.superheltev3.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Repository
public class SuperheroRepository {
    private ArrayList<Superhero> superheroes = new ArrayList<>();
    private boolean changesMade = false;

    public SuperheroRepository() {
        this.superheroes.add(new Superhero("Superman", "Flying", "Alien", 1926, 100000));
        this.superheroes.add(new Superhero("Batman", "Rich", "Human", 1939, 500));
        this.superheroes.add(new Superhero("Captain America", "Strong", "Human", 1938, 1000));
        this.superheroes.add(new Superhero("Spider-man", "Does what a spider can", "Human", 1956, 5000));
        this.superheroes.add(new Superhero("Ant-Man", "Does what an ant can", "Human", 1987, 2000));
        this.superheroes.add(new Superhero("Hulk", "Strong", "Human", 1975, 2000));
        this.superheroes.add(new Superhero("Bat-girl", "Sneaky", "Human", 1995, 200));
    }

    public ArrayList<Superhero> getSuperheroes() {
        return this.superheroes;
    }


    public boolean getChangesMade() {
        return changesMade;
    }

    public void setChangesMade() {
        this.changesMade = true;
    }

    public void addSuperhero(String name, String superpower, String form, int yearIntroduced, double strength) {
        this.superheroes.add(new Superhero(name, superpower, form, yearIntroduced, strength));
        setChangesMade();
    }
    public void addSuperhero(Superhero superhero) {
        this.superheroes.add(superhero);
    }

    public boolean delete(String name) {
        for (Superhero superhero: superheroes) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                superheroes.remove(superhero);
                setChangesMade();
                return true;
            }
        }
        return false;
    }

    public void sortSuperheroes(int choice) {
        Collections.sort(superheroes, new Comparator<Superhero>() {
            @Override
            public int compare(Superhero s1, Superhero s2) {
                switch (choice) {
                    case 1: {
                        return String.valueOf(s1.getName()).compareTo(String.valueOf(s2.getName()));
                    }
                    case 2: {
                        return String.valueOf(s1.getSuperPower()).compareTo(String.valueOf(s2.getSuperPower()));
                    }
                    case 3: {
                        return String.valueOf(s1.getForm()).compareTo(String.valueOf(s2.getForm()));
                    }
                    case 4: {
                        return Double.valueOf(s1.getStrength()).compareTo(Double.valueOf(s2.getStrength()));
                    }
                    case 5: {
                        return s1.getYearIntroduced() - s2.getYearIntroduced();
                    }
                    default: {
                        return String.valueOf(s1.getName()).compareTo(String.valueOf(s2.getName()));
                    }
                }
            }
        });
    }
}
