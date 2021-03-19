package com.example.util.service;

import com.example.util.model.Dog;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface DogService {
    List<Dog> findAllDogs();

    Optional<Dog> findOneDog(Long id);

    List<Dog> findByAgeGreater(Integer age);

    Dog findDogByRace(String race);

    List<Dog> findByIsVaccinated(Boolean isVaccinated);


    Optional<Dog> findOnByName(String name);

    Dog createDog(Dog dog);


    // UPDATE
    Dog updateDog(Dog dog);

    // DELETE
    ResponseEntity<Void> deleteById(Long id);
    ResponseEntity<Void> deleteAllDogs();

}
