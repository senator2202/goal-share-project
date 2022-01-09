package com.goalshare.project.goalsharerest.service.impl;

import com.goalshare.project.goalsharerest.model.dto.UserRegistrationDto;
import com.goalshare.project.goalsharerest.model.dto.UserDto;
import com.goalshare.project.goalsharerest.model.entity.User;
import com.goalshare.project.goalsharerest.repository.UserRepository;
import com.goalshare.project.goalsharerest.service.UserService;
import com.goalshare.project.goalsharerest.util.ObjectConversionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto add(UserRegistrationDto data) {
        User user = ObjectConversionUtil.convertToUserEntity(data);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saved = userRepository.save(user);
        return ObjectConversionUtil.convertToUserDto(saved);
    }
}
