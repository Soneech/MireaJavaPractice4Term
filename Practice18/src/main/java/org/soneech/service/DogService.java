package org.soneech.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.soneech.models.Dog;
import org.soneech.models.User;
import org.soneech.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DogService {
    private DogRepository dogRepository;

    @Autowired
    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Dog> getDogs() {
        return dogRepository.findAll();
    }

    public Dog getDogById(int id) {
        return dogRepository.findById(id);
    }

    public void addDog(Dog dog) {
        dogRepository.save(dog);
    }

    public void deleteDog(Dog dog) {
        dogRepository.delete(dog);
    }

    public void updateDog(int id, Dog updatedDog) {
        Dog dog = getDogById(id);
        dog.setName(updatedDog.getName());
        dog.setBreed(updatedDog.getBreed());
        addDog(dog);
    }

    public List<Dog> orderedDogsByBreed() {
        return dogRepository.findAll(Sort.by("breed"));
    }
}
