/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daftarmahasiswa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FAKHRI F
 */
public class dbConnection {
    private Statement stmt = null;
    private Statement conn = null;
    
    public dbConnection(){
        String ConAddress = "jdbc:mysql://localhost/db_latihan_dpo";
        String user = "root";
        String pass = "";
        connect(ConAddress, user, pass);
    }
}

private void connect(String ConAddress, String username, String pass){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(ConAddress, username, pass);
        stmt = conn.createStatement();
    } catch(ClassNotFoundException | SQLException ex){
        System.out.println(ex.getMessage());
    }
}

public ResultSet selectQuery(String sql){
    try{
        stmt.executeQuery(sql);
        return stmt.getResultSet();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return 0;
}

public int updateQuery(String sql){
    try{
        return stmt.executeUpdate(sql);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return 0;
}

public Statement getStatement(){
    return stmt;
}