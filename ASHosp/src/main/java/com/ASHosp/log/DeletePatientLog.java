package com.ASHosp.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DeletePatientLog {
    @Around("execution(*.com.ASHosp.controller.DeletePatientController.deletePatient(..))")
    public Object deletePatientButtonClicked(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Delete Patient Button Clicked");
        Object result = joinPoint.proceed();
        System.out.println("After Method: "+joinPoint.getSignature().getName());
        return result;
    }
}
