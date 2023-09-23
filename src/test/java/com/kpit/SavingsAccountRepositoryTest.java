package com.kpit;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kpit.entity.SavingsAccount;
import com.kpit.repository.SavingsAccountRepository;

@SpringBootTest
public class SavingsAccountRepositoryTest {

	@Autowired
	SavingsAccountRepository accountRepository;
	
	
	@Test
	public void readAllData() {
		List<SavingsAccount> allAccounts = (List<SavingsAccount>) accountRepository.findAll();
		System.out.println("All Accounts ....");
		for (SavingsAccount savingsAccount : allAccounts) {
			System.out.println("Account Number : "+ savingsAccount.getAccountNumber());
			System.out.println("Account Holder Name : "+savingsAccount.getAccountHolderName());
			System.out.println("Account Balance : "+savingsAccount.getAccountBalance());
			System.out.println("**********************************");
		}
	}
	
	@Test
	public void addNewAccount() {
		SavingsAccount account = new SavingsAccount();
		account.setAccountNumber(2);
		account.setAccountHolderName("Shravan");
		account.setAccountBalance(1000);
		accountRepository.save(account);
		System.out.println("New Account Added Successfully....");
	}
	
	@Test
	public void updateAccount() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account for the updation ");
		int id = sc.nextInt();
		Optional<SavingsAccount> checkAccount = accountRepository.findById(id);
		if(checkAccount.isPresent()) {
			SavingsAccount account = checkAccount.get();
			account.setAccountHolderName("Shravan Sharma");
			account.setAccountBalance(100000);
			accountRepository.save(account);
			System.out.println(" Account Updated Successfully....");
		}
		else {
			System.out.println("Account Not Found!!!");
		}
	}
	@Test
	public void deleteAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the account for the Deleteion ");
		int id = sc.nextInt();
		Optional<SavingsAccount> checkAccount = accountRepository.findById(id);
		if(checkAccount.isPresent()) {
			accountRepository.delete(checkAccount.get());
			System.out.println(" Account Deleted Successfully....");
		}
	}
}
