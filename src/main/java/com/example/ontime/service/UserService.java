package com.example.ontime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ontime.entity.User;
import com.example.ontime.model.dto.UserDTO;
import com.example.ontime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
            return userRepository.findById(id);
        }

    public void addUser(UserDTO userDTO) {
         User user = new User();
         user.setName(userDTO.getName());
         user.setEmail(userDTO.getEmail());
         user.setPassword(userDTO.getPassword());
         user.setId(userDTO.getId());
         userRepository.save(user);
    }

    public void updateUser(String Id, UserDTO userDTO) {
        Optional<User> user = userRepository.findById(Id);
            if (user.isPresent()) {
                User existingUser = user.get();
                existingUser.setName(userDTO.getName());
                existingUser.setEmail(userDTO.getEmail());
                existingUser.setPassword(userDTO.getPassword());
                userRepository.save(existingUser);
            }
        }
    public void deleteUser(String Id) {
            userRepository.deleteById(Id);
        }
}

