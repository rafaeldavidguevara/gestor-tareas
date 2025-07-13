package com.nuevo.spa.gestortareas.user.application;

import com.nuevo.spa.gestortareas.exception.NotFoundException;
import com.nuevo.spa.gestortareas.user.domain.User;
import com.nuevo.spa.gestortareas.user.domain.UserRepository;
import com.nuevo.spa.gestortareas.user.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User update(User updateUser) {

        User user = userRepository.findById(updateUser.getId()).orElseThrow(() -> new NotFoundException("User not found"));

        BeanUtils.copyProperties(updateUser, user, "role");

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) throws NotFoundException {

        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
