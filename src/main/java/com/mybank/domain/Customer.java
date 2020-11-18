package com.mybank.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private String firstName;

  private String lastName;

  private ArrayList<Account> accounts;

  public Customer(String f, String l) {
    firstName = f;
    lastName = l;
    // initialize accounts array
    accounts = new ArrayList<Account>(10);
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void addAccount(Account cuenta) {
      this.accounts.add(cuenta);
  }

  public int getNumOfAccounts() {
    return this.accounts.size();
  }

  public Account getAccount(int account_index) {
    return this.accounts.get(account_index);
  }
  
  public void MuestraAccount(){
      for(Account s: accounts){
          System.out.println("Customer: " + this.getFirstName() + ", " + this.getLastName());
          System.out.println("Balance: " + s.getBalance());
      }
  }
  
}
