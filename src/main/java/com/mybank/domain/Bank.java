package com.mybank.domain;

import java.util.ArrayList;

public class Bank {
  private static ArrayList<Customer> customers;

  static {
    //customers = new Customer[10];
    //numberOfCustomers = 0;
      customers = new ArrayList<Customer>(10);
  }

  private Bank() {
    // this constructor should never be called
  }

  public static void addCustomer(String f, String l) {
//    int i = numberOfCustomers++;
//    customers[i] = new Customer(f, l);
    customers.add(new Customer(f,l));
  }
  
  public static int getNumOfCustomers() {
    return customers.size();
  }
  
  public static Customer getCustomer(int customer_index) {
    return customers.get(customer_index);
  }
}
