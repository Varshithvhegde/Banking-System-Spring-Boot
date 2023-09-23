package com.kpit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpit.dto.Response;
import com.kpit.entity.SavingsAccount;
import com.kpit.service.SavingsAccountServiceImplementation;


@RestController
@RequestMapping("/api/accounts")
public class SavingsAccountController {

	@Autowired
	SavingsAccountServiceImplementation accountServiceImplementation;
	
	@GetMapping("/getAllAccountDetails")
	public List<SavingsAccount> getAllTheAccountDetails(){
		return accountServiceImplementation.getAllAccountDetails();
	}
	
	@PostMapping("/addNewAccount")
	public ResponseEntity<Object> addAAccountToRecords(@RequestBody SavingsAccount account){
		Response response = new Response(accountServiceImplementation.addNewAccount(account));
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteAnAccount/{id}")
	public ResponseEntity<Object> deleteAGivenAccount(@PathVariable("id") Integer id){
		Response response = new Response(accountServiceImplementation.deleteAAccount(id));
		return new ResponseEntity<Object>(response , HttpStatus.ACCEPTED);
	}
	@PutMapping("/updateAAccount")
	public ResponseEntity<Object> updateAGivenAccount(@RequestBody SavingsAccount account){
		Response response = new Response(accountServiceImplementation.updateAAccount(account));
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAnAccount/{id}")
	public SavingsAccount getASingleAccountDetails(@PathVariable("id") Integer id){
		return accountServiceImplementation.getASingleAccountDetails(id);
	}
}
