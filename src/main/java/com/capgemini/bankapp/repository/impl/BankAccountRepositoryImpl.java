package com.capgemini.bankapp.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.capgemini.bankapp.dbutil.DbUtil;
import com.capgemini.bankapp.entities.BankAccount;

import com.capgemini.bankapp.repository.BankAccountRepository;
@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

    @Autowired
	DbUtil databaseUtil;
	
	@Override
	public double getBalance(long accountId) throws AccountNotFoundException {
		String query = "SELECT balance FROM bankAccount WHERE account_Id = ?";
		try (Connection connection = databaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			
			statement.setLong(1, accountId);
			try(ResultSet result = statement.executeQuery()){
			if (result.next()) {
				return result.getDouble(1);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new AccountNotFoundException("Account doesn't exist!");
	}
	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		String query = "UPDATE bankAccount SET balance = ? WHERE account_Id = ?";
		try (Connection connection = databaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setDouble(1, newBalance);
			statement.setLong(2, accountId);
			if(statement.executeUpdate() != 0) {
				System.out.println("Record inserted successfully");
			return true;}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean addBalanceAccount(BankAccount account) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public BankAccount findBAnkAccountById(long accountId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BankAccount> findAllBankAccount() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BankAccount updateBankAccount(BankAccount account) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean deleteBankAccount(long accountId) {
		// TODO Auto-generated method stub
		return false;
	}
}