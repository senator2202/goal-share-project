package com.goalshare.project.goalsharerest.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserRegistrationDto extends UserAuthenticationDto {

    @NotNull(message = "The email can not be null")
    @NotEmpty(message = "The email can not be empty")
    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message = "The password can not be null")
    @NotEmpty(message = "The password can not be empty")
    private String passwordRepeat;

    public UserRegistrationDto(String email, String username, String password, String passwordRepeat) {
        super(username, password);
        this.email = email;
        this.passwordRepeat = passwordRepeat;
    }
}
