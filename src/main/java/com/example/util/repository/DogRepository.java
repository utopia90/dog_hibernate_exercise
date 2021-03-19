package com.example.util.repository;

import com.example.util.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog,Long> {
  Dog findByRace(String race);

  List<Dog> findByIsVaccinated(Boolean isVaccinated);

  List<Dog> findAllByAgeAfter(Integer age);
}

