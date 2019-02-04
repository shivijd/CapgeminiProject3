package com.capgemini.Repo;

import com.capgemini.Acc.AccountClass;

public interface AccountRepo {

abstract boolean  save(AccountClass accounts);
abstract AccountClass createAccount(int acountNumber,int amount); 
 int depositAmount(int acountNumber,int amount);
abstract int withdrawAmount(int acountNumber,int amount);
abstract AccountClass searchAccount(int accNumber);
}
