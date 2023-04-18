package org.soneech.controllers;

import org.soneech.models.Dog;
import org.soneech.service.DogService;
import org.soneech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dogs")
public class DogsController {
    private final DogService dogService;
    private final UserService userService;

    @Autowired
    public DogsController(DogService dogService, UserService userService) {
        this.dogService = dogService;
        this.userService = userService;
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

    @GetMapping("/new/{ownerId}")
    public String newDogPage(@PathVariable("ownerId") int ownerId, @ModelAttribute("dog") Dog dog) {
        return "dogs/new";
    }

    @PostMapping("/new/{ownerId}")
    public String create(@PathVariable("ownerId") int ownerId, @ModelAttribute("dog") Dog dog) {
        dog.setUser(userService.getUserById(ownerId));
        dogService.addDog(dog);
        return "redirect:/dogs";
    }

    @DeleteMapping("/{id}")
    public String deleteDog(@PathVariable("id") int id) {
        dogService.deleteDog(dogService.getDogById(id));
        return "redirect:/dogs";
    }

    @GetMapping("/{id}/edit")
    public String updatePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("dog", dogService.getDogById(id));
        return "dogs/update";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("dog") Dog dog) {
        dogService.updateDog(id, dog);
        return "redirect:/dogs";
    }
}
