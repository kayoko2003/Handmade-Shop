/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;

/**
 *
 * @author ngoc
 */
public class DBContext {
    protected Connection connection;
    
    public DBContext(){
        try{
            String url = "jdbc:sqlserver://" + serverName + ":" +portNumber + ";databaseName=" + dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, userID, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private final String serverName ="localhost";
    private final String dbName ="Crochet_shop";
    private final String portNumber ="1433";
    private final String userID ="sa";
    private final String password ="kayokocute2003";
}
