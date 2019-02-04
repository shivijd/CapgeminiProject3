package com.capgemini.Service;

import com.capgemini.Acc.AccountClass;
import com.capgemini.Exception1.InavalidOpeningAccountException;
import com.capgemini.Exception2.InsufficientBalanceException;
import com.capgemini.Exception3.InvalidAccountNumberException;

public interface AccountServiceN {

	//@Override
	AccountClass createAccount(int acountNumber, int amount) throws InavalidOpeningAccountException;

	int depositAmount(int acountNumber, int amount)throws InvalidAccountNumberException;

	int  withdrawAmount(int acountNumber, int amount )throws InsufficientBalanceException,InvalidAccountNumberException;

}