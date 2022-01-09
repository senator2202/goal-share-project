package com.goalshare.project.goalsharerest.service.impl;

import com.goalshare.project.goalsharerest.model.entity.Goal;
import com.goalshare.project.goalsharerest.model.dto.GoalDto;
import com.goalshare.project.goalsharerest.repository.GoalRepository;
import com.goalshare.project.goalsharerest.service.GoalService;
import com.goalshare.project.goalsharerest.util.ObjectConversionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    @Override
    public List<GoalDto> findAll() {
        return goalRepository.findAll()
                .stream()
                .map(ObjectConversionUtil::convertToGoalDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GoalDto> findById(long id) {
        return goalRepository.findById(id)
                .map(ObjectConversionUtil::convertToGoalDto);
    }

    @Override
    public GoalDto saveGoal(GoalDto goalDto) {
        goalDto.setId(0);
        Goal goalEntity = ObjectConversionUtil.convertToGoalEntity(goalDto);
        Goal savedEntity = goalRepository.save(goalEntity);
        return ObjectConversionUtil.convertToGoalDto(savedEntity);
    }

    @Override
    public GoalDto update(long id, GoalDto goalDto) {
        if (goalRepository.existsById(id)) {
            goalDto.setId(id);
            Goal entity = ObjectConversionUtil.convertToGoalEntity(goalDto);
            return ObjectConversionUtil.convertToGoalDto(goalRepository.save(entity));
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void delete(long id) {
        if (goalRepository.existsById(id)) {
            goalRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
