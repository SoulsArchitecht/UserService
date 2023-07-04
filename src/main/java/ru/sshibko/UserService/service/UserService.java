package ru.sshibko.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sshibko.UserService.model.entity.Role;
import ru.sshibko.UserService.model.entity.User;
import ru.sshibko.UserService.model.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        if (user == null) {
            return;
        }
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        if (id == null) {
            return null;
        }
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    public void deleteUserByEmail(Long id) {
        if (id == null) {
            return;
        }
        userRepository.deleteById(id);
    }

    public void changeRoleByUserId(Long id) {
        if (id == null) {
            throw new RuntimeException();
        }
        User user = userRepository.findById(id).orElse(null);
        if (user.getRole().equals(Role.USER)) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }
        userRepository.save(user);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
