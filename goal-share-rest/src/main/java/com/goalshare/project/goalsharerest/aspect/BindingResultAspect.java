package com.goalshare.project.goalsharerest.aspect;

import com.goalshare.project.goalsharerest.controller.exception.BindingResultException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.Optional;

@Component
@Aspect
public class BindingResultAspect {

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void checkBindingResult(JoinPoint joinPoint) {
        Optional<BindingResult> optionalBindingResult = Arrays.stream(joinPoint.getArgs())
                .filter(a -> a instanceof BindingResult)
                .map(BindingResult.class::cast)
                .findFirst();
        if (optionalBindingResult.isPresent()) {
            BindingResult bindingResult = optionalBindingResult.get();
            if (bindingResult.hasErrors()) {
                BindingResultException exception = new BindingResultException();
                bindingResult.getFieldErrors().forEach(f -> exception.put(f.getField(), f.getDefaultMessage()));
                throw exception;
            }
        }
    }
}
