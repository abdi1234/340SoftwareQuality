/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Isaac
 */
public class StockProcess {
    //Call to data access object
    StockRepoImpl stkRepo = new StockRepoImpl();

   public void register(int id, String name, String price, Date arrivalDate, int quantity, int minRequired, int maxRequired, String staffRole, Connection conn){
        //Get entity object for Instructor
        Stock stk = new Stock();
        //Using setters
        stk.setId(id);
        stk.setName(name);
        stk.setDate(arrivalDate);
        stk.setQuantity(quantity);
        stk.setMin(minRequired);
        stk.setMax(maxRequired);
        stk.setPrice(price);
        stk.setRole(staffRole);
        //Send data to data access object
        stkRepo.addStock(stk, conn);
    } 


   /* public void updateDetails(int id, String disab, String niNo, String addr, BigDecimal wage, BigDecimal tax, BigInteger phone, BigInteger emerg, Connection conn){
        ArrayList list = stkRepo.getAllStock();
        boolean found  = false;
        int i = 0;
        while (i<list.size() && !found){
               Stock temp = (Stock)list.get(i);
               if (id == temp.getId()){
                   temp.setDisability(disab);
                   temp.setNiNo(niNo);
                   temp.setAddress(addr);
                   temp.setWages(wage);
                   temp.setTax(tax);
                   temp.setPhoneNo(phone);
                   temp.setEmergencyNo(emerg);
                   stkRepo.updateStock(temp, conn);
                   found = true;
               }
           i++;
           }               
    }              
*/

    public void viewDetails(int id){
    ArrayList list = stkRepo.getAllStock();

    boolean found  = false;
    int i = 0;
    while (i<list.size() && !found){
           Stock temp = (Stock)list.get(i);
           if (id == temp.getId()){
               System.out.print("Stock details: \n Name: " + temp.getName() + 
                "\n Arrival Date: " +  temp.getDate() + "\n Quantity: " + temp.getQuantity() + 
                "\n Min Required: " + temp.getMin()+ "\n Max Required: " + temp.getMax() + 
                "\n Price: " + temp.getPrice() + "\n Role: " + temp.getRole()+"\n");

               found = true;
           }
       i++;
       }  
    }    

   public void viewAll(){
   ArrayList list = stkRepo.getAllStock();
   for (int i = 0; i<list.size(); i++){
           Stock temp = (Stock)list.get(i);
               System.out.print("Stock details: \n ID: " + temp.getId() + 
                "\n Name: " + temp.getName() + 
                "\n Arrival Date: " +  temp.getDate() + "\n Quantity: " + temp.getQuantity() + 
                "\n Min Required: " + temp.getMin()+ "\n Max Required: " + temp.getMax() + 
                "\n Price: " + temp.getPrice() + "\n Role: " + temp.getRole()+"\n");
       }              
    }

    public void setStockList(ArrayList list){

         stkRepo.setStocks(list);
    } 

    public void deleteDetails(int id, Connection conn){
       Stock stock = new Stock();
       stock.setId(id);
       stkRepo.deleteStock(stock, conn);
    }

}
