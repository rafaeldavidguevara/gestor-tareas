package com.nuevo.spa.gestortareas.user.infrastructure;

import com.nuevo.spa.gestortareas.user.infrastructure.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {

    ResponseEntity<UserDTO> findById(Long id);

    ResponseEntity<List<UserDTO>> findAll();

    ResponseEntity<UserDTO> update(UserDTO userDTO);

    ResponseEntity<Void> delete(Long id);
}
