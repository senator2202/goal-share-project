package com.goalshare.project.goalsharerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class GoalShareRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoalShareRestApplication.class, args);
    }
}
