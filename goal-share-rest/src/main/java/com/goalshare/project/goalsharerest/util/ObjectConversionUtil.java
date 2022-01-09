package com.goalshare.project.goalsharerest.util;

import com.goalshare.project.goalsharerest.model.Goal;
import com.goalshare.project.goalsharerest.model.GoalDto;

import java.util.Date;
import java.util.Objects;

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
        Date current = new Date();
        return Goal.builder()
                .id(goal.getId())
                .shortName(goal.getShortName())
                .description(goal.getDescription())
                .startDate(goal.getStartDate() != null ? goal.getStartDate() : current)
                .endDate(goal.getEndDate())
                .build();
    }
}
