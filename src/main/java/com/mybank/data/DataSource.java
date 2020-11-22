/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybank.data;

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
import java.util.Scanner;

/**
 *
 * @author user
 */
public class DataSource {
    private File archivo = null; 
    private String url = "src/main/java/com/mybank/data/test.dat";
    private final String NAME = "test2.txt";

//    static {
//        archivo = null;
//    }
    
    //Version 2
//    public DataSource(String dataFilePath) {
//        this.archivo = new File(dataFilePath);
//    }
    
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
        float initBalance;
        String firstName, lastName, numOfCustomersParse;
        numOfCustomersParse = sc.nextLine();
        int numOfCustomers = Integer.parseInt(numOfCustomersParse);
        try{
            //NOMBRE Y APELLIDO
            out = new PrintWriter(this.archivo);
            firstName = sc.nextLine();
            lastName = sc.nextLine();
            out.println(numOfCustomers);
            out.println(""+firstName);
            out.println(""+lastName);
            //Escribiendo en el fichero
            out.close();
        }
        catch(IOException e){
            System.out.println("No se ha podido escribir");
        }
        finally{     
            if(out != null)
                out.close();
        }
//        FileWriter fw = null;
//        PrintWriter out = null;
//        try {
//            fw = new FileWriter(fichero);
//            out = new PrintWriter(fw);
//            out.println("Esto es una linea");
//            out.println("Esto es otra linea");
//            //Escribiendo en el fichero
////            fw.write("Cuenta - Tipo de Cuenta - Persona");
////            fw.write("1 - AHORRO - Manuel Higueras");
////            fw.append("\n");
////            fw.write("2 - DEBITO - Luis Ponte");
////            fw.write("3 - AHORRO - Paco Quesada");
////            fw.write("4 - AHORRO - Roni Loz");
////            fw.append('1');
////            fw.close();
//            out.close();
//        }
//        catch(IOException e){
//            System.out.println("No se ha podido escribir");
//        }
//        finally {
//            if(fw != null) 
//                fw.close();
//            if(out != null) 
//                out.close();
//        }
    }
    
//    public void loadData() throws IOException {// Variables de fuente de datosScanner 
//            Scanner input = new Scanner(this.archivo);// Variables de dominio
//            Customer customer;
//            int numOfCustomers = input.nextInt();
//            float initBalance;
//            String firstName, lastName;
//            for ( int idx = 0; idx < numOfCustomers; idx++ ) {// Crear objeto de cliente
//                firstName = input.next();
//                lastName = input.next();
//                Bank.addCustomer(firstName, lastName);
//                customer = Bank.getCustomer(idx);// Crear cuentas de cliente
//                int numOfAccounts = input.nextInt();
//                while ( numOfAccounts-- > 0 ) {// Crear un tipo de cuenta específico
//                    char accountType = input.next().charAt(0);
//                    switch ( accountType ) {// Cuenta de ahorro
//                        case 'S':{
//                            initBalance = input.nextFloat();
//                        }
//                        float interestRate = input.nextFloat();
//                        customer.addAccount(new SavingsAccount(initBalance,interestRate));
//                        break;
//                        // Checking account
//                        case 'C':{
//                            initBalance = input.nextFloat();
//                        }
//                    float overdraftProtection = input.nextFloat();
//                    customer.addAccount(new CheckingAccount(initBalance,overdraftProtection));
//                    break;
//                }
//            } // FIN de cambio
//       } // FIN de bucle de creación de cuentas
//    }
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
    
/*
    public void writeData() throws IOException {
    //ESCRIBIR EN EL FICHERO
    Scanner sc = new Scanner(System.in);
    PrintWriter out = null;
    Customer customer;
    float initBalance;
    String firstName, lastName, numOfCustomersParse, numOfAccountsParse;
    numOfCustomersParse = sc.nextLine();
    int numOfCustomers = Integer.parseInt(numOfCustomersParse);
    try{
        //NOMBRE Y APELLIDO
        out = new PrintWriter(this.archivo);
        out.println(numOfCustomers);
        for ( int idx = 0; idx < numOfCustomers; idx++ ) {// Crear objeto de cliente
          firstName = sc.nextLine();
          lastName = sc.nextLine();
          out.println(""+firstName);
          out.println(""+lastName);
          Bank.addCustomer(firstName, lastName);
          customer = Bank.getCustomer(idx);
          numOfAccountsParse = sc.nextLine();
          int numOfAccounts = Integer.parseInt(numOfAccountsParse);
          while ( numOfAccounts-- > 0 ) {
            char accountType = sc.nextLine().charAt(0);
            switch ( accountType ) {// Cuenta de ahorro
              case 'S':
              {
                  
              }
              break;
          //Escribiendo en el fichero
        out.close();
    }
    catch(IOException e){
        System.out.println("No se ha podido escribir");
    }
    finally{     
        if(out != null)
            out.close();
    }    
*/
    
}