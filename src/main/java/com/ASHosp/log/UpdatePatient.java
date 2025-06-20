package com.ASHosp.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class UpdatePatient {
    @Around("execution(*.com.ASHosp.controller.UpdatePatient.updatePatient(..))")   
    public Object updateButtonClickedLog(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Update Patient Button Clicked");
        Object result= joinPoint.proceed();
        System.out.println("After Execution: "+joinPoint.getSignature().getName());
        return result;
    }


    @Around("execution(*.com.ASHosp.controller.UpdatePatient.submitUpdated(..))")   
    public Object updateButtonSubmittedClickedLog(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Update of Patient Submitted");
        Object result= joinPoint.proceed();
        System.out.println("After Execution: "+joinPoint.getSignature().getName());
        return result;
    }
}
