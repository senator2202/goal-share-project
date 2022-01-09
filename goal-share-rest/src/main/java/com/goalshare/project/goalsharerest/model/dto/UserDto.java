package com.goalshare.project.goalsharerest.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    private long id;
    private String username;
    private String email;
}
