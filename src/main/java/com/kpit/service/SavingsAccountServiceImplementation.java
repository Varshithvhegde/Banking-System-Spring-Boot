package com.kpit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpit.entity.SavingsAccount;
import com.kpit.exceptions.AccountAlreadyExistException;
import com.kpit.exceptions.AccountNotFoundException;
import com.kpit.repository.SavingsAccountRepository;

@Service
public class SavingsAccountServiceImplementation implements SavingsAccountService{

	@Autowired
	SavingsAccountRepository accountRepository;

	@Override
	public List<SavingsAccount> getAllAccountDetails() {
		// TODO Auto-generated method stub
		return (List<SavingsAccount>) accountRepository.findAll();
	}

	@Override
	public SavingsAccount getASingleAccountDetails(int id) {
		// TODO Auto-generated method stub
		Optional<SavingsAccount> checkAccountExist = accountRepository.findById(id);
		if(checkAccountExist.isPresent()) {
			return checkAccountExist.get();
		}
		else {
			throw new AccountNotFoundException("Account Id is Invalid");
		}
	}

	@Override
	public String addNewAccount(SavingsAccount account) {
		// TODO Auto-generated method stub
		System.out.println(account.getAccountHolderName());
		Optional<SavingsAccount> checkAccountExistOptional = accountRepository.findById(account.getAccountNumber());
		if(checkAccountExistOptional.isEmpty()) {
			accountRepository.save(account);
			System.out.println("Account is checked");
			return "New Account Added Successfully";
		}
		else {
			throw new AccountAlreadyExistException("Account with Same ID Already Exists..");
		}
	}

	@Override
	public String deleteAAccount(int id) {
		// TODO Auto-generated method stub
		Optional<SavingsAccount> checkAccountExistOptional = accountRepository.findById(id);
		if(checkAccountExistOptional.isPresent()) {
			accountRepository.delete(checkAccountExistOptional.get());
			return "Account Deleted Successfully";
		}
		else {
			throw new AccountNotFoundException("Account with given Account Number Not Found!!!");
		}
	}

	@Override
	public String updateAAccount(SavingsAccount account) {
		// TODO Auto-generated method stub
		Optional<SavingsAccount> checkAccountExistOptional = accountRepository.findById(account.getAccountNumber());
		if(checkAccountExistOptional.isPresent()) {
			accountRepository.save(account);
			return "New Account Added Successfully";
		}
		else {
			throw new AccountNotFoundException("Account with given Account Number Not Found!!!");
		}
	}
	

	
	
	
	
	
}
