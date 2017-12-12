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
import java.math.BigInteger;
import java.util.ArrayList;
import java.sql.*;

public class StockRepoImpl implements StockRepo {
    private ArrayList<Stock> stocks;
        
    public StockRepoImpl(){
        stocks = new ArrayList<Stock>();
    }        

    public StockRepoImpl(ArrayList list){
        stocks = list;
    } 

    public void addStock(Stock stock, Connection conn){
        
        stocks.add(stock); 
        write(conn,  "add",  stock);

    }
        
    public Stock getStock(Stock stock){
        return stocks.get(stock.getId()); 
    }
    
    public ArrayList<Stock> getAllStock(){
        return stocks; 
    } 
    
    public void setStocks(ArrayList list){
        stocks = list; 
    }
/*
    public void updateStock(Stock instructor, Connection conn){
            ArrayList stocks = getAllStock();
            boolean found = false;
            int i = 0;
            while ((!found) && (i<stocks.size())) {
                Stock temp = (Stock)stocks.get(i);
                if (instructor.getId() == temp.getId()){
                    temp.setName(instructor.getName());
                    temp.setDob(instructor.getDob());
                    temp.setDisability(instructor.getDisability());
                    temp.setNiNo(instructor.getNiNo());
                    temp.setAddress(instructor.getAddress());
                    temp.setWages(instructor.getWages());
                    temp.setTax(instructor.getTax());
                    temp.setPhoneNo(instructor.getPhoneNo());
                    temp.setEmergencyNo(instructor.getEmergencyNo());
                    System.out.println("Stock ID: "+ stock.getId()+ " updated");
                    
                    found = true;
                }
                i++;
            }
        
            write(conn, "update", instructor);
    }
    */
    public void deleteStock(Stock stock, Connection conn){ 

            ArrayList stocks = getAllStock(); 
            ArrayList tempList = new ArrayList();
            
            for (int i = 0; i<stocks.size(); i++) {
                Stock temp = (Stock)stocks.get(i);
                if (stock.getId() != temp.getId()){
                    tempList.add(temp);    
                }
            }
            setStocks(tempList);

            System.out.println("Stock ID: "+ stock.getId()+ " deleted");
            
            write(conn, "delete", stock);

    }
  
   
    public ArrayList notification(Connection conn){
        System.out.println("Reading from the database... ");
        ArrayList list = new ArrayList();
        try {   
                Statement st = conn.createStatement();
                ResultSet rs = null;
                String sql = "SELECT * FROM Stock";
                rs=st.executeQuery(sql);
                while(rs.next()){ 
                    Stock stk = new Stock();
                    stk.setId(rs.getInt("ID"));
                    stk.setName(rs.getString("NAME"));
                    stk.setPrice(rs.getString("PRICE"));
                    stk.setDate(java.sql.Date.valueOf(rs.getString("ARRIVALDATE")));
                    stk.setQuantity(rs.getInt("QUANTITY"));
                    stk.setMin(rs.getInt("MINREQUIRED"));
                    stk.setMax(rs.getInt("MAXREQUIRED"));
                    stk.setRole(rs.getString("STAFFROLE"));
                    list.add(stk);
                    System.out.println(rs.getInt("ID")+"\t"+rs.getString("NAME")+
                            "\t"+rs.getString("PRICE")+"\t"+rs.getString("ARRIVALDATE")+
                            "\t"+rs.getInt("QUANTITY")+"\t"+rs.getInt("MINREQUIRED")+
                            "\t"+rs.getInt("MAXREQUIRED")+"\t"+rs.getString("STAFFROLE"));
                }
                    rs.close();
                    st.close();
        } catch (SQLException ex) {
                    System.out.println("SQLException failed ! ");
        } 
        stocks = list;
        System.out.println("Stock count: " + list.size());
        return stocks;
    }
    
    public void write(Connection conn, String str, Stock stock){
        System.out.println("Writing to the database... ");
        if (str.equals("add")){
            try {   
                Statement st = conn.createStatement();
                String sql = "INSERT INTO STOCK VALUES (" + stock.getId() + ",'" + stock.getName() + 
                        "'," + stock.getQuantity() + ",'" + stock.getDate() + "'," + stock.getMin()+
                        "," + stock.getMax() + ",'"+ stock.getRole() + "','"+ stock.getPrice() + "')";
                st.executeUpdate(sql);
                st.close();
            }
            catch (SQLException ex) {
                    System.out.println(" error " + ex.getMessage());
            }         
        }
        else if (str.equals("update")) {
            try {   
                    Statement st = conn.createStatement();
              
                    String sqlQuan = "UPDATE STOCK SET quantity = " + stock.getQuantity()+ " WHERE id =" + stock.getId()+ ""; 
                    st.executeUpdate(sqlQuan);
                    String sqlDate = "UPDATE STOCK SET arrivaldate = '" + stock.getDate()+ "' WHERE id =" + stock.getId()+ ""; 
                    st.executeUpdate(sqlDate);                    
                    st.close();                    
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error "+ ex.getMessage());
            }                                  
        }
        else if (str.equals("delete")) {
            try {   
                    Statement st = conn.createStatement();
              
                    String sql = "DELETE FROM STOCK WHERE ID = " + stock.getId()+ " ";
                    st.executeUpdate(sql);

                    st.close();
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error ");
            }                             
        }   
    }    
    public static void main(String[] args) {
        
    }

}
