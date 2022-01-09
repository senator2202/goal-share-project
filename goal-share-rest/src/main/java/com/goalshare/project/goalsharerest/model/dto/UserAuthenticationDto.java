package com.goalshare.project.goalsharerest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class UserAuthenticationDto {

    @NotNull(message = "The username can not be null")
    @NotEmpty(message = "The username can not be empty")
    private String username;
    @NotNull(message = "The password can not be null")
    @NotEmpty(message = "The password can not be empty")
    private String password;
}
