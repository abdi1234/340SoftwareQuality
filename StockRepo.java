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
import java.sql.*;
import java.util.ArrayList;

public interface StockRepo {
    public void addStock(Stock stok, Connection conn);
    public Stock getStock(Stock stock);
    public ArrayList<Stock> getAllStock();
    public void setStocks(ArrayList list);    
   // public void updateStock(Stock inst, Connection conn);
    public void deleteStock(Stock dent, Connection conn);
    public ArrayList notification(Connection conn);
    void write(Connection conn, String str, Stock instructor);

    
}
