package com.capgemini.bankapp;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.capgemini.bankapp.config.AppConfig;
import com.capgemini.bankapp.controller.BankAccountController;

public class Application {
public static void main(String args[]) throws AccountNotFoundException {
/*	ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");*/
	ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
	BankAccountController bankAccountController=context.getBean("bankAccountController",BankAccountController.class);
	System.out.println(bankAccountController.getBalance(100));
	System.out.println(bankAccountController.getBalance(101));
}

}

