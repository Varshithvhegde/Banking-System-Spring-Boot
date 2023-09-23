package com.kpit;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kpit.entity.SavingsAccount;
import com.kpit.service.SavingsAccountServiceImplementation;

@SpringBootTest
public class SavingsAccountServiceTest {

	@Autowired
	SavingsAccountServiceImplementation implementation;

	@Test
	public void readAllData() {
		List<SavingsAccount> accounts = implementation.getAllAccountDetails();
		System.out.println("All Accounts ....");
		for (SavingsAccount savingsAccount : accounts) {
			System.out.println("Account Number : " + savingsAccount.getAccountNumber());
			System.out.println("Account Holder Name : " + savingsAccount.getAccountHolderName());
			System.out.println("Account Balance : " + savingsAccount.getAccountBalance());
			System.out.println("**********************************");
		}
	}

	@Test
	public void addNewAccount() {
		SavingsAccount account = new SavingsAccount();
		account.setAccountNumber(3);
		account.setAccountHolderName("Maanikya");
		account.setAccountBalance(10000);
		System.out.println(implementation.addNewAccount(account));
		System.out.println("New Account Added Successfully....");
	}

	@Test
	public void updateAccount() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account for the updation ");
		int id = sc.nextInt();
		SavingsAccount account = new SavingsAccount();
		account.setAccountNumber(id);
		account.setAccountHolderName("Shravan Sharma");
		account.setAccountBalance(100000);
		implementation.updateAAccount(account);
	}
	
	@Test
	public void deleteAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account for the Deleteion ");
		int id = sc.nextInt();
		implementation.deleteAAccount(id);
	}

}
