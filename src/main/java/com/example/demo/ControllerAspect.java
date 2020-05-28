package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspect {
	
    @AfterThrowing ("execution(* com.example.demo.Controller.who(*))")
    public void onError() throws Throwable {
    	System.out.println("RRRRRRRRH");
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.Controller.who(*))", returning = "response")
    public void onSuccess(JoinPoint jp, Object response) throws Throwable {
    	System.out.println("YEAAAAAAH");
    }
}
