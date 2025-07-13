package com.nuevo.spa.gestortareas.user.domain;

import java.util.List;

public interface UserService {

    User update(User user);

    List<User> findAll();

    User findById(Long id);

    void delete(Long id);

}
