///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mybank.data;
//
///**
// *
// * @author Manuel
// */
//public class Modificacion {
//     public void loadData() throws IOException {// Variables de fuente de datosScanner 
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
//}
