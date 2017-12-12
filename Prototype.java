/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;
import java.sql.* ;  // for standard JDBC programsimport java.sql.Connection;
import java.util.*;
import java.io.*;

/**
 *
 * @author Isaac
 */
public class Prototype {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Run the menu interface ---------
        String demoOptions[] = {"Stock Control Assistant", "Manager", "Exit the System"};  
        char demoChoice;          
        Menu demoMenu= new Menu("Menu ", demoOptions, "Enter the menu option: "); 
        
        boolean exit = true;
        while (exit){
            System.out.println("----------------------------------------------");
            demoChoice = demoMenu.offerMenu();
            
            switch (demoChoice){
             case 'A': //to manage Stock Control Assistant actions 
                 
                try {
                    String connectionURL = "jdbc:derby://localhost:1527/SCM";
                    String uName = "abdi";
                    String uPass= "123";
                    //Initialise data access object
                    StockRepoImpl stkRepo = new StockRepoImpl();
                    //get connection
                    Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
                    System.out.println("Connect to database..."); 

                    if (conn != null){ 
                        ArrayList list = stkRepo.notification(conn);
                        
                        //Call to user interface class
                        StockControlUI ui = new StockControlUI(conn, list);
                        ui.displayMenu();     

                        conn.close();
                        System.out.println("Connection is closed.");

                        System.exit(1);

                    } else {
                        System.out.println("null"); 
                    }
                 }
                catch (SQLException ex) {             
                    System.out.println("Connection failed.");         
                }           
                //-------------------------------------------
            break; 
            
            case 'B': //to view a Manager details 
                try{
                    String connectionURL = "jdbc:derby://localhost:1527/SCM";
                    String uName = "abdi";
                    String uPass= "123";
                    //Initialise data access object
                    StockRepoImpl stkRepo = new StockRepoImpl();
                    //get connection
                    Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
                    System.out.println("Connect to database..."); 

                    if (conn != null){ 
                        ArrayList list = stkRepo.notification(conn);

                        ManagerUI ui = new ManagerUI(conn, list);
                        ui.displayMenu();     

                        conn.close();
                        System.out.println("Connection is closed.");

                        System.exit(1);

                    } else {
                        System.out.println("null"); 
                    }
                 }
                catch (SQLException ex) {             
                    System.out.println("Connection failed.");         
                }  
                
                //-------------------------------------------
            break;       
            
            
            
            case 'C': //to exist the system 

	        System.out.println("You have exited the system."); 
                exit = false;
            }
                
        }          
    }    

}
