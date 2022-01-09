package com.goalshare.project.goalsharerest.service.impl;

import com.goalshare.project.goalsharerest.model.entity.User;
import com.goalshare.project.goalsharerest.repository.UserRepository;
import com.goalshare.project.goalsharerest.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser
                .map(u -> new SecurityUser(
                        u.getUsername(),
                        u.getPassword(),
                        Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                        u.getId(), false))
                .orElseThrow(
                        () -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
    }
}
