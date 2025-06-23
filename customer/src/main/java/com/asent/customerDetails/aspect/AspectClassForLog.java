package com.asent.customerDetails.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectClassForLog {
    @Before("execution(* com.asent.customerDetails.controllers.CustomerController.ModelAcreateCustomerPage(..))")
    public void callPeformAddingCustomer(){
            System.out.println("Customer Creation Method Requested By User.");
    }
    @After("execution(* com.asent.customerDetails.controllers.CustomerController.saveCustomer(..))")
    public void afterAddingCustomer(){
        System.out.println("Customer creation method execution finished (clicked submit button)");
    }

    @Before("execution(* com.asent.customerDetails.controllers.CustomerController.goToDisplayPage(..))")
    public void displayAll(){
        System.out.println("Display all is requested...");
    }

    @Before("execution(* com.asent.customerDetails.controllers.CustomerController.deleteUser(..))")
    public void logdeleteUser(){
        System.out.println("Delete User Button Clicked");
    }
    
    @Before("execution(* com.asent.customerDetails.controllers.CustomerController.updateUser(..))")
    public void logUpdateUser(){
        System.out.println("Delete User Button Clicked");
    }

    @Around("execution(* com.asent.customerDetails.controllers.RootController.redirectToAsent(..))")
    public Object startAndStop(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("redirected to asent");
        Object obj=joinPoint.proceed();
        System.out.println("reached to asent");
        return obj;

    }
}
