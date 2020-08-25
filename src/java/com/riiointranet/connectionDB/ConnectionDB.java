/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riiointranet.connectionDB;

import com.sun.javafx.binding.StringConstant;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andressolanoramirez
 */
public class ConnectionDB {
    private String db = "IdentArchi";
    private String url = "jdbc:mysql://localhost:3306/"+db;
    private String user="AdminArchi";
    private String pass="AdminArchi2019ASR";
    /*private String db = "dnnyvngs";   
    private String url = "jdbc:mysql://72.13.93.206:3307/"+db+"?autoReconnect=true";
    private String user="dnnyvngs";
    private String pass="vngs1110";*/
    
     public Connection GetConnection()
    {        
        Connection conexion=null;
      
        try
        {                                    
            Class.forName("org.gjt.mm.mysql.Driver");            
            conexion= (Connection) DriverManager.getConnection(this.url,this.user,this.pass);                        
        }
        catch(ClassNotFoundException ex)
        {      
            conexion=null;
            throw new Exception("Error1 en la Conexión con la BD "+ex.getMessage());
            //JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);            
        }
        catch(SQLException ex)
        {
            //JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
            throw new Exception("Error2 en la Conexión con la BD "+ex.getMessage());
        }
        catch(Exception ex)
        {
            //JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
            throw new Exception("Error3 en la Conexión con la BD "+ex.getMessage());
        }
        finally
        {
            return conexion;
        }
    }
     
    public ResultSet ExecuteSP(String storeProcedure) throws SQLException{
        
        Connection cn = GetConnection();
        String query = "{call "+storeProcedure+"}";
        
        CallableStatement stmt = cn.prepareCall(query);
        
        ResultSet result = stmt.executeQuery();
        
        return result;        
    }
    
    public ResultSet ExecuteSP(String storeProcedure, String parameters) throws SQLException{        
            Connection cn = GetConnection();
            String query = "{call "+storeProcedure+" ("+ parameters +")}";
            
            CallableStatement stmt = cn.prepareCall(query);
            
            ResultSet result = stmt.executeQuery();
                 
            return result;        
    }
}
