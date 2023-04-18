package org.soneech.service;

import lombok.RequiredArgsConstructor;
import org.soneech.models.Dog;
import org.soneech.models.User;
import org.soneech.repository.DogRepository;
import org.soneech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private DogRepository dogRepository;

    @Autowired
    public UserService(UserRepository userRepository, DogRepository dogRepository) {
        this.userRepository = userRepository;
        this.dogRepository = dogRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        dogRepository.deleteAll(user.getDogs());
        userRepository.delete(user);
    }

    public void updateUser(int id, User updatedUser) {
        User user = getUserById(id);
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        addUser(user);
    }

    public List<User> orderedUsersByFirstName() {
        return userRepository.findAll(Sort.by("firstName"));
    }

    public List<User> orderedUsersByLastName() {
        return userRepository.findAll(Sort.by("lastName"));
    }
}
