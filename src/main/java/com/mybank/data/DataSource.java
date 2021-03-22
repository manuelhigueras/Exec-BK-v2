/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.data;

import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class DataSource {
    private File archivo = null; 
    private String url = "src/main/java/com/mybank/data/test.dat";
    private final String NAME = "test2.txt";
    
    public DataSource(String dataFilePath2){
        this.archivo = new File(dataFilePath2, NAME);
        this.url = dataFilePath2;
    }
    
    public void existData() throws IOException{
        if(! archivo.exists() ){
            System.out.println(" el archivo no existe. Crea el fichero");
        }
        else{
            System.out.printf("El fichero %s, ya existe", archivo.getName());
        }  
    }
    
    public void writeData() throws IOException {
        //ESCRIBIR EN EL FICHERO
        Scanner sc = new Scanner(System.in);
        PrintWriter out = null;
        Customer customer;
        float initBalance, interestRate, overdraftProtection;
        String firstName, lastName, numOfCustomersParse, numOfAccountsParse;
        String initBalanceParse, interestRateParse, overdraftProtectionParse;
        numOfCustomersParse = sc.nextLine();
        int numOfCustomers = Integer.parseInt(numOfCustomersParse);
        try{
            //NOMBRE Y APELLIDO
            out = new PrintWriter(this.archivo);
            out.println(numOfCustomers);
            out.println("");
            for ( int idx = 0; idx < numOfCustomers; idx++ ) {// Crear objeto de cliente
              firstName = sc.nextLine();
              lastName = sc.nextLine();
              Bank.addCustomer(firstName, lastName);
              customer = Bank.getCustomer(idx);
              numOfAccountsParse = sc.nextLine();
              int numOfAccounts = Integer.parseInt(numOfAccountsParse);
              out.println(""+ firstName + "   " + lastName + "   " + numOfAccounts);
              while ( numOfAccounts-- > 0 ) {
                char accountType = sc.nextLine().charAt(0);
                switch ( accountType ) {// Cuenta de ahorro
                  case 'S':
                    initBalanceParse = sc.nextLine();
                    initBalance = Float.parseFloat(initBalanceParse);
                    interestRateParse = sc.nextLine();
                    interestRate = Float.parseFloat(interestRateParse) / 100;
                    out.println("" + accountType + "    " + initBalance + "   " + interestRate);
                    customer.addAccount(new SavingsAccount(initBalance,interestRate));
                  break;
                  case 'C':
                    initBalanceParse = sc.nextLine();
                    initBalance = Float.parseFloat(initBalanceParse);
                    overdraftProtectionParse = sc.nextLine();
                    overdraftProtection = Float.parseFloat(overdraftProtectionParse);
                    out.println("" + accountType + "    " + initBalance + "   " + overdraftProtection);
                    customer.addAccount(new CheckingAccount(initBalance,overdraftProtection));
                  break;
                  default:
                    System.out.println("ERROR CON EL TIPO DE CUENTA");
                }
              }
            }
            //Cerrando el fichero
            out.close();
        }
        catch(IOException e){
            System.out.println("No se ha podido escribir");
        }
        finally{
            if(out != null)
                out.close();
        }
    }    
    
    public void loadData(){
        FileReader fr = null;
        try{
            fr = new FileReader(this.archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            
            while(linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("No se ha podido leer " + e.getMessage());
        }
    }
    
    public void loadDataV3() throws IOException{
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(this.archivo);
            br = new BufferedReader(fr);
            //leo primera linea qeu me da un numero
            String linea = br.readLine();
            int numeroClientes = Integer.parseInt(linea);
            System.out.printf("Total clientes %d \n", numeroClientes);
            //leo linea en blanco
            linea =  br.readLine();
            for(int i = 0; i < numeroClientes; i++){
                //leo datos cliente
                linea = br.readLine();
                // System.out.println(linea);
                Scanner sc = new Scanner(linea);
                String nom = sc.next();
                String ap = sc.next();
                String cuenta = sc.next();
                int numeroCuentas = Integer.parseInt(cuenta);
                Bank.addCustomer(nom, ap);
                for(int j = 0; j < numeroCuentas; j++){
                    //leer cuentas
                    linea = br.readLine(); 
                    Scanner sc2 = new Scanner(linea);
                    sc2.useLocale(Locale.US);
                    String tipo = sc2.next();
                    double balance = sc2.nextDouble();
                    double interes = sc2.nextDouble();
                    break;
//                    Account ac= null;
//                    if( tipo.equals("S")){
//                        //new SA
//                        ac = new SavingsAccount(balance, interes);
//                    }else{
//                        // new CA
//                        ac = new CheckingAccount(balance, interes);
//                    }
//                   Customer c =  Bank.getCustomer(Bank.getNumOfCustomers()-1);
//                   c.addAccount(ac);
                }//fin recorrer cuentas
                linea = br.readLine(); 
            }//fin recorrer clientes
           // Scanner sc = new Scanner(linea)
        }finally{
           if(fr != null) fr.close();
           if(br != null) br.close();
        }
           
    }
    
    public void loadDataV2(){
        FileReader fr = null;
        try{
            fr = new FileReader(this.archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("No se ha podido leer " + e.getMessage());
        }
    }
    
}