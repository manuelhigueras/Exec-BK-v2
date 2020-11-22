package com.mybank.test;

import com.mybank.data.DataSource;
import com.mybank.domain.*;
import com.mybank.report.*;
import java.io.IOException;

public class TestReport {
    
    public static void main(String[] args) throws IOException {
        initializeCustomers();
        
        // run the customer report
        CustomerReport report = new CustomerReport();
        report.generateReport();
    }
    
    private static void initializeCustomers() throws IOException {
        Customer customer;
        
        // Create several customers and their accounts
//        Bank.addCustomer("Jane", "Simms");
//        customer = Bank.getCustomer(0);
//        customer.addAccount(new SavingsAccount(500.00, 0.05));
//        customer.addAccount(new CheckingAccount(200.00, 400.00));
//        customer.MuestraAccount();
//        
//        Bank.addCustomer("Owen", "Bryant");
//        customer = Bank.getCustomer(1);
//        customer.addAccount(new CheckingAccount(200.00));
//        
//        Bank.addCustomer("Tim", "Soley");
//        customer = Bank.getCustomer(2);
//        customer.addAccount(new SavingsAccount(1500.00, 0.05));
//        customer.addAccount(new CheckingAccount(200.00));
//        
//        Bank.addCustomer("Maria", "Soley");
//        customer = Bank.getCustomer(3);
////         Maria and Tim have a shared checking account
//        customer.addAccount(Bank.getCustomer(2).getAccount(1));
//        customer.addAccount(new SavingsAccount(150.00, 0.05));
        
        DataSource file = new DataSource("src/main/java/com/mybank/data/");
        file.existData();
        file.writeData();
        //file.loadDataV2();
        
    }
}
