package com.goalshare.project.goalsharerest;

import com.goalshare.project.goalsharerest.config.DataSourceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties(DataSourceProperties.class)
public class GoalShareRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoalShareRestApplication.class, args);
    }
}
