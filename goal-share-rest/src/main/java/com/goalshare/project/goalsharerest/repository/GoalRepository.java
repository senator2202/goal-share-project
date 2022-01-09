package com.goalshare.project.goalsharerest.repository;

import com.goalshare.project.goalsharerest.model.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
}
