package com.goalshare.project.goalsharerest.service;

import com.goalshare.project.goalsharerest.model.dto.GoalDto;

import java.util.List;
import java.util.Optional;

public interface GoalService {

    List<GoalDto> findAll();

    Optional<GoalDto> findById(long id);

    GoalDto saveGoal(GoalDto goal);

    GoalDto update(long id, GoalDto goalDto);

    void delete(long id);
}
