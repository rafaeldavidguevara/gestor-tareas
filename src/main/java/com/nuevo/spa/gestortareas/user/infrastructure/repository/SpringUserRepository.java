package com.nuevo.spa.gestortareas.user.infrastructure.repository;

import com.nuevo.spa.gestortareas.user.domain.User;
import com.nuevo.spa.gestortareas.user.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringUserRepository extends CrudRepository<UserEntity, Long> {

    Boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findAll();
}
