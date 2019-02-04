package com.capgemini.Acc;

public class AccountClass {
private int accountNumber;
private int amount;
public int getAccountNumber() {
	return accountNumber;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + accountNumber;
	result = prime * result + amount;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AccountClass other = (AccountClass) obj;
	if (accountNumber != other.accountNumber)
		return false;
	if (amount != other.amount)
		return false;
	return true;
}
public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
}
