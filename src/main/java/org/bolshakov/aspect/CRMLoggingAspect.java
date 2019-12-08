package org.bolshakov.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    // set up logger
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* org.bolshakov.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* org.bolshakov.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* org.bolshakov.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}

    // добавляем before advise
    @Before("forAppFlow()")
    public void beforeAop(JoinPoint theJoinPoint){
        // метод кот вызывается
        String theMethod = theJoinPoint.getSignature().toShortString();
        logger.info("in before advise: particularly in " + theMethod);
        // получаем аргументы
        Object[] args = theJoinPoint.getArgs();
        for (Object getArgs: args) {
            logger.info(" in before:" + getArgs);
        }
    }


    // After returning advise
    @AfterReturning(pointcut = "forAppFlow()",returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){
    // дисплеем метод
        String method = theJoinPoint.getSignature().toShortString();
        logger.info("in After advise: " + method);
    // получаем параметры
        logger.info("args:" + theResult);
    }

}
