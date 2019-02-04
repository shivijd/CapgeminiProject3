package com.capgemini.Service;

import com.capgemini.Acc.AccountClass;
import com.capgemini.Exception1.InavalidOpeningAccountException;
import com.capgemini.Exception2.InsufficientBalanceException;
import com.capgemini.Exception3.InvalidAccountNumberException;
import com.capgemini.Repo.AccountRepo;
public class AccountServiceImplementation implements AccountServiceN {

	
	AccountRepo accRepo;

	public AccountServiceImplementation(AccountRepo accRepo) {
		super();
		this.accRepo = accRepo;
	}
	//@Override
	/* (non-Javadoc)
	 * @see com.capgemini.Service.AccountServiceN#createAccount(int, int)
	 */
	@Override
	public AccountClass createAccount(int acountNumber,int amount)throws InavalidOpeningAccountException
	{
		if(amount<500)
		{
			throw new InavalidOpeningAccountException();
		}
		AccountClass account=new AccountClass();
		account.setAccountNumber(acountNumber);
		account.setAmount(amount);
		if(accRepo.save(account))
		{
			return account;
		}
		return null;
	}
	public int depositAmount(int accNumber,int amount) throws InvalidAccountNumberException
	{
		AccountClass acc=accRepo.searchAccount(accNumber);
		if(acc==null) {
			System.out.println("null");
			throw new InvalidAccountNumberException();
			}
		acc.setAmount(acc.getAmount()+amount);
		return acc.getAmount();
	}
	 public int withdrawAmount(int accNumber,int amount)throws InsufficientBalanceException,InvalidAccountNumberException
	  {
		 
		  AccountClass acc=accRepo.searchAccount(accNumber);
		  if(acc==null)
				throw new InvalidAccountNumberException();
		  else if(acc.getAmount()-amount>=0)
		  {
			  acc.setAmount(acc.getAmount()-amount);
			  return acc.getAmount();
		  }
		  throw new InsufficientBalanceException();
	  }
}
