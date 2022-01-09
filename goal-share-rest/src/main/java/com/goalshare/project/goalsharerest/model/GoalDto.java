package com.goalshare.project.goalsharerest.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Builder
public class GoalDto {

    private long id;
    @NotNull(message = "The goal name can not be a null")
    @NotEmpty(message = "The goal name can not be empty")
    private String shortName;
    private String description;
    private Date startDate;
    @NotNull(message = "End date can not be a null")
    private Date endDate;
}
