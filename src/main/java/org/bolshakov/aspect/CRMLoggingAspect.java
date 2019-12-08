package org.bolshakov.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRBLoggingAspect {
    // set up logger
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* org.bolshakov.springdemo.controller.*.*.(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* org.bolshakov.service.*.*.(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* org.bolshakov.dao.*.*.(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}
}
