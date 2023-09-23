package com.kpit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kpit.entity.SavingsAccount;

@Service
public interface SavingsAccountService {

	List<SavingsAccount> getAllAccountDetails();
	
	SavingsAccount getASingleAccountDetails(int id);
	
	String addNewAccount(SavingsAccount account);
	
	String deleteAAccount(int id);
	
	String updateAAccount(SavingsAccount account);
	
}
