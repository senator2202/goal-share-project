package com.goalshare.project.goalsharerest.service;

import com.goalshare.project.goalsharerest.model.dto.UserRegistrationDto;
import com.goalshare.project.goalsharerest.model.dto.UserDto;

/**
 * Interface provides operation on Order entity.
 */
public interface UserService {

    /**
     * Add user method.
     *
     * @param data user registration data
     * @return the user dto
     */
    UserDto add(UserRegistrationDto data);
}
