package com.capgemini.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.Acc.AccountClass;
import com.capgemini.Exception1.InavalidOpeningAccountException;
import com.capgemini.Exception2.InsufficientBalanceException;
import com.capgemini.Exception3.InvalidAccountNumberException;
import com.capgemini.Repo.AccountRepo;
import com.capgemini.Service.AccountServiceImplementation;
import com.capgemini.Service.AccountServiceN;


public class TestCases {
	AccountServiceN accService;
	@Mock
	AccountRepo accRepo;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accService=new AccountServiceImplementation(accRepo);	
	}
	@Test(expected=com.capgemini.Exception1.InavalidOpeningAccountException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InavalidOpeningAccountException
	{
		accService.createAccount(101, 100);
	}
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InavalidOpeningAccountException
	{
		AccountClass account =new AccountClass();
		account.setAccountNumber(101);
		account.setAmount(5000);
		when(accRepo.save(account)).thenReturn(true);
		assertEquals(account, accService.createAccount(101, 5000));
	}
	@Test(expected=com.capgemini.Exception3.InvalidAccountNumberException.class)	
public void whenCorrectAccountNumberIsNotPassedThrowException() throws InvalidAccountNumberException
{
		accService.depositAmount(101,2000);
}
	@Test
	public void whenValidAccountNumberIsPassedAndDepositedSuccessfully() throws InvalidAccountNumberException
	{
		AccountClass account =new AccountClass();
		account.setAccountNumber(101);
		account.setAmount(200);
		when(accRepo.searchAccount(101)).thenReturn(account);
		assertEquals(account.getAmount()+200,accService.depositAmount(101, 200));
	}
	@Test(expected=com.capgemini.Exception3.InvalidAccountNumberException.class)	
	public void whenAccounNumberIsNotPresentThrowException() throws InvalidAccountNumberException, InsufficientBalanceException
	{
	accService.withdrawAmount(101,5000);
	}
	@Test(expected=com.capgemini.Exception2.InsufficientBalanceException.class)	
	public void whenSufficientAmountIsNotPresentThrowException() throws InsufficientBalanceException,InvalidAccountNumberException
	{
		AccountClass account=new AccountClass();
		account.setAccountNumber(101);
		account.setAmount(5000);
		when(accRepo.searchAccount(101)).thenReturn(account);
	accService.withdrawAmount(101,6000);
	}

	public void whenSufficientAmountIsAvailableAndWithdrawDoneSuccessfully() throws InsufficientBalanceException,InvalidAccountNumberException
	{

AccountClass account=new AccountClass();
account.setAccountNumber(101);
account.setAmount(5000);
when(accRepo.searchAccount(101)).thenReturn(account);
assertEquals(account.getAmount()-500,accService.withdrawAmount(101,500));
	}
}
