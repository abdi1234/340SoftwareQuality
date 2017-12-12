/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

/**
 *
 * @author Isaac
 */

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;

public class StockControlUI {
    /**
     * @param args the command line arguments
     */   
        
    //Run the menu interface ---------
    String demoOptions[] = {"Add a new Stock"};  
    char demoChoice;          
    Menu demoMenu= new Menu("Menu ", demoOptions, "Enter the menu option: ");          
    StockProcess stk = new StockProcess(); 
    Connection conn;
        
    public StockControlUI(Connection aConn, ArrayList aList) {
        conn = aConn;
        stk.setStockList(aList);
    }
    
    public void displayMenu() {
        boolean exit = true;
        while (exit){
            System.out.println("----------------------------------------------");
            demoChoice = demoMenu.offerMenu();
            int id;
            String name;
            String price;
            Date arrivalDate;
            int quantity;
            int minRequired;
            int maxRequired;
            String staffRole;
            
            BufferedReader keyboard;
            switch (demoChoice){
            case 'A': //to add a new Stock
                try {
                    keyboard = new  BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter ID number:"); 
                    String inputId = keyboard.readLine();
                    id = Integer.parseInt(inputId);
                    System.out.println("Enter name:"); 
                    name = keyboard.readLine(); 
                    System.out.println("Enter price:"); 
                    price = keyboard.readLine();                   
                    System.out.println("Enter Arrival Date(YYYY-MM-DD):"); 
                    String inputDate = keyboard.readLine();
                    arrivalDate = java.sql.Date.valueOf(inputDate);
                    System.out.println("Enter quantity:"); 
                    String inputQu = keyboard.readLine();
                    quantity = Integer.parseInt(inputQu);
                    System.out.println("Enter min required:"); 
                    String inputMin = keyboard.readLine();
                    minRequired = Integer.parseInt(inputMin);
                    System.out.println("Enter max required:"); 
                    String inputMax = keyboard.readLine();
                    maxRequired = Integer.parseInt(inputMax);
                    System.out.println("Enter staff role:"); 
                    staffRole = keyboard.readLine();

                    stk.register(id, name, price, arrivalDate, quantity, minRequired, maxRequired, staffRole, conn);
                }
                catch (java.io.IOException exception){} 
                //-------------------------------------------                
            break;

            case 'B': //to view a dentist details 
                try {
                    System.out.println("Enter ID number:"); 
                    keyboard = new  BufferedReader(new InputStreamReader(System.in));
                    String inputId = keyboard.readLine();
                    id = Integer.parseInt(inputId);

                    stk.viewDetails(id);
                 }
                catch (java.io.IOException exception){} 
                //-------------------------------------------
            break;       
            /*
            case 'C': //to view all dentist details 
                    stk.viewAll();
                //-------------------------------------------
            break;  */     
            /*            
            case 'D': //to update a dentist details
                try {
                    System.out.println("Enter ID number:"); 
                    keyboard = new  BufferedReader(new InputStreamReader(System.in));
                    String inputId = keyboard.readLine();
                    id = Integer.parseInt(inputId);
                    System.out.println("Enter disability:"); 
                    disab = keyboard.readLine();
                    System.out.println("Enter National Insurance No:"); 
                    niNo = keyboard.readLine();
                    System.out.println("Enter address:"); 
                    addr = keyboard.readLine();
                    System.out.println("Enter wage:"); 
                    String wages = keyboard.readLine();
                    wage = new BigDecimal(wages);
                    System.out.println("Enter tax:");
                    String taxes = keyboard.readLine();
                    tax = new BigDecimal(taxes);
                    System.out.println("Enter phone number:"); 
                    String inputPhone = keyboard.readLine();
                    phone = new BigInteger(inputPhone);
                    System.out.println("Enter emergency number:"); 
                    String inputEmerg = keyboard.readLine();
                    emerg = new BigInteger(inputEmerg);

                    stk.updateDetails(id, disab, niNo, addr, wage, tax, phone, emerg, conn);
                }
                catch (java.io.IOException exception){} 
                //-------------------------------------------
            break; 

            case 'E': //to delete a dentist 
                try {
                    System.out.println("Enter ID number:"); 
                    keyboard = new  BufferedReader(new InputStreamReader(System.in));
                    String inputId = keyboard.readLine();
                    id = Integer.parseInt(inputId);

                    stk.deleteDetails(id, conn);
                }
                catch (java.io.IOException exception){} 
                //-------------------------------------------
            break;     
            
            case 'F': //to exist the system
                

	        System.out.println("You have exited the system."); 
                exit = false;

            }*/
        }//end while
      }//end 

}
    
}
