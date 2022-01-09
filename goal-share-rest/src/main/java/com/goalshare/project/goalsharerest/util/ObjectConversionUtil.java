package com.goalshare.project.goalsharerest.util;

import com.goalshare.project.goalsharerest.model.dto.UserDto;
import com.goalshare.project.goalsharerest.model.dto.UserRegistrationDto;
import com.goalshare.project.goalsharerest.model.entity.Goal;
import com.goalshare.project.goalsharerest.model.dto.GoalDto;
import com.goalshare.project.goalsharerest.model.entity.User;

import java.util.Date;

public class ObjectConversionUtil {

    public static GoalDto convertToGoalDto(Goal goal) {
        return GoalDto.builder()
                .id(goal.getId())
                .shortName(goal.getShortName())
                .description(goal.getDescription())
                .startDate(goal.getStartDate())
                .endDate(goal.getEndDate())
                .build();
    }

    public static Goal convertToGoalEntity(GoalDto goal) {
        return Goal.builder()
                .id(goal.getId())
                .shortName(goal.getShortName())
                .description(goal.getDescription())
                .startDate(goal.getStartDate() != null ? goal.getStartDate() : new Date())
                .endDate(goal.getEndDate())
                .build();
    }

    public static User convertToUserEntity(UserRegistrationDto userRegistrationDto) {
        return User.builder()
                .username(userRegistrationDto.getUsername())
                .email(userRegistrationDto.getEmail())
                .password(userRegistrationDto.getPassword())
                .build();
    }

    public static UserDto convertToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
