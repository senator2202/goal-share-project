package com.goalshare.project.goalsharerest.controller;

import com.goalshare.project.goalsharerest.model.dto.GoalDto;
import com.goalshare.project.goalsharerest.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/goals")
@RequiredArgsConstructor
public class GoalRestController {

    private final GoalService goalService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<GoalDto>> findAll() {
        List<GoalDto> goals = goalService.findAll();
        return ResponseEntity.ok(goals);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<GoalDto> findById(@PathVariable long id) {
        Optional<GoalDto> goal = goalService.findById(id);
        return goal
                .map(ResponseEntity::ok)
                .orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping
    public ResponseEntity<GoalDto> save(@Valid @RequestBody GoalDto goal, BindingResult bindingResult) {
        GoalDto saved = goalService.saveGoal(goal);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalDto> update(@Valid @RequestBody GoalDto goal, BindingResult bindingResult, @PathVariable long id) {
        GoalDto updated = goalService.update(id, goal);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        goalService.delete(id);
    }

}
