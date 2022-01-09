package com.goalshare.project.goalsharerest.controller;

import com.goalshare.project.goalsharerest.model.dto.UserAuthenticationDto;
import com.goalshare.project.goalsharerest.model.dto.UserRegistrationDto;
import com.goalshare.project.goalsharerest.security.JwtTokenProvider;
import com.goalshare.project.goalsharerest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private static final String USER_NAME_MAP_KEY = "userName";
    private static final String TOKEN_MAP_KEY = "token";

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<Map<String, String>> authenticate(@Valid @RequestBody UserAuthenticationDto authenticationDTO, BindingResult bindingResult) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword()));
        return getTokenResponseEntity(authenticationDTO.getUsername());
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ResponseEntity<Map<String, String>> registerUser(@Valid @RequestBody UserRegistrationDto data, BindingResult bindingResult) {
        userService.add(data);
        return getTokenResponseEntity(data.getUsername());
    }

    @DeleteMapping("/logout")
    @PreAuthorize("isAuthenticated()")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpStatus.NO_CONTENT.value());
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, response, null);
    }

    private ResponseEntity<Map<String, String>> getTokenResponseEntity(String userName) {
        String token = jwtTokenProvider.createToken(userName);
        Map<String, String> response = new HashMap<>();
        response.put(USER_NAME_MAP_KEY, userName);
        response.put(TOKEN_MAP_KEY, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
