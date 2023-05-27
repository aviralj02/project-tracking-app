package com.pta.project_tracking_app.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {

	@After("execution(* com.pta.project_tracking_app.controller.*.processLogin(..))")
	public void afterLoginAdvice() {
		System.out.println("\n=========>>>> User Logged In");
	}
	
	@After("execution(* com.pta.project_tracking_app.controller.*.processRegister(..))")
	public void afterRegisterAdvice() {
		System.out.println("\n=========>>>> New User Registered");
	}
	
	@After("execution(* com.pta.project_tracking_app.controller.*.processAdminLogin(..))")
	public void afterAdminLoginAdvice() {
		System.out.println("\n=========>>>> Admin Logged In");
	}
	
	@After("execution(* com.pta.project_tracking_app.controller.*.processLogout(..))")
	public void afterLogoutAdvice() {
		System.out.println("\n=========>>>> User Logged Out");
	}
	
	@After("execution(* com.pta.project_tracking_app.controller.*.adminLogout(..))")
	public void afterAdminLogoutAdvice() {
		System.out.println("\n=========>>>> Admin Logged Out");
	}
	
	
}
