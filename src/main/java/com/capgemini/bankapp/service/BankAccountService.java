package com.capgemini.bankapp.service;

import javax.security.auth.login.AccountNotFoundException;

import com.capgemini.bankapp.exception.LowBalanceException;

public interface BankAccountService {
	
	public double getBalance(long accountId) throws AccountNotFoundException;
	public double withdraw(long accountId, double amount) throws LowBalanceException, AccountNotFoundException;
	public double deposit(long accountId, double amount) throws AccountNotFoundException;
	public boolean fundTransfer(long fromAccount, long toAccount, double balance) throws LowBalanceException, AccountNotFoundException;
	
}