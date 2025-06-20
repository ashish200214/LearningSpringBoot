package com.ASHosp.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppointmentControllerLogClass {
    @Around("execution(*.com.ASHosp.controller.AppoitmentController.goToAppointmentPage(..))")
    public Object aroundAppointmentPageLog(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Appointment Button Clicked : "+joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();    
        System.out.println("After method: "+joinPoint.getSignature().getName());
        return result;
    }

    @Around("execution(*.com.ASHosp.controller.AppoitmentController.saveAppointment(..))")
    public Object aroundSaveAppointmentLog(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Appointment Submitted");
        Object result= joinPoint.proceed();
        System.out.println("After method: "+joinPoint.getSignature().getName());
        return result;
    }

    @Around("execution(*.com.ASHosp.controller.AppoitmentController.allAppointment(..))")
    public Object aroundAllAppointmentLog(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("All Appointment Clicked"+joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("After Method: "+joinPoint.getSignature().getName());
        return result;
    }

    @Around("execution(*.com.ASHosp.controller.AppoitmentController.searchAppointment(..))")
    public Object searchAppointmentLog(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Search Appointment Clicked");
        Object result = joinPoint.proceed();
        System.out.println("After Method: "+joinPoint.getSignature().getName());
        return result;
    }

        @Around("execution(*.com.ASHosp.controller.AppoitmentController.deleteAppointment(..))")
        public Object deleteAppointmentClickedLog(ProceedingJoinPoint joinPoint) throws Throwable{
            System.out.println("Delete Button of Appointment is Clicked");
            Object result = joinPoint.proceed();
            System.out.println("After Method: "+joinPoint.getSignature().getName());
            return result;
        }

    

}
