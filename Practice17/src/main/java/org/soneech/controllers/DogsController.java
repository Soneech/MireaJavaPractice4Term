package org.soneech.controllers;

import org.soneech.models.Dog;
import org.soneech.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dogs")
public class DogsController {
    private final DogService dogService;

    @Autowired
    public DogsController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public String dogs(Model model) {
        List<Dog> dogs = dogService.getDogs();
        model.addAttribute("dogs", dogs);
        return "dogs/dogs";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Dog dog = dogService.getDogById(id);
        model.addAttribute("dog", dog);
        return "dogs/show";
    }

    @GetMapping("/ordered")
    public String orderedDogs(Model model) {
        List<Dog> dogs = dogService.orderedDogsByBreed();
        model.addAttribute("dogs", dogs);
        return "/dogs/dogs";
    }
}
