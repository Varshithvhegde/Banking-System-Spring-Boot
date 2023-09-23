package com.kpit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kpit.entity.SavingsAccount;

@Repository
public interface SavingsAccountRepository extends CrudRepository<SavingsAccount, Integer> {

}
