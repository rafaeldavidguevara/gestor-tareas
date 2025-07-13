package com.nuevo.spa.gestortareas.user.infrastructure.mapper;

import com.nuevo.spa.gestortareas.auth.infrastructure.RegisterRequest;
import com.nuevo.spa.gestortareas.user.domain.User;
import com.nuevo.spa.gestortareas.user.infrastructure.dto.UserDTO;
import com.nuevo.spa.gestortareas.user.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User userEntityToUser(UserEntity userEntity);

    UserEntity userToUserEntity(User user);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

    User registerRequestToUser(RegisterRequest registerRequest);
}
