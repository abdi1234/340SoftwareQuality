/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

/**
 *
 * @author lamar
 */
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;

public class ManagerUI {
     //Run the menu interface ---------
    String demoOptions[] = {"View a stock","Delete an item"};  
    char demoChoice;          
    Menu demoMenu= new Menu("Menu ", demoOptions, "Enter the menu option: ");          
        
    StockProcess stk = new StockProcess();
        
    ArrayList list = new ArrayList();
    Connection conn;
        
    public ManagerUI(Connection aConn, ArrayList aList) {
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
            case 'A': //to view an item details 
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
        
            case 'B': //to delete a item 
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
            
            
            }
        }//end while
      }//end 
}
