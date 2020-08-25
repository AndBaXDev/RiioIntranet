/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riiointranet.business;

import com.riiointranet.connectionDB.ConnectionDB;
import com.riiointranet.domain.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author andressolanoramirez
 */
public class AccionesCliente {
    
    public ArrayList<Cliente> ObtieneClientes() throws SQLException{
        
        ConnectionDB cnDB = new ConnectionDB();        
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        ResultSet results;
        
        results = cnDB.ExecuteSP("RiioCR.sp_ObtieneClientes");
        while (results.next()) {               
            
            Cliente cliente = new Cliente();

            cliente.setIdentificacion(results.getString("identificacion"));   
            cliente.setNombre(results.getString("nombre"));
            cliente.setApellidos(results.getString("apellidos"));
            cliente.setProvincia(results.getString("provincia"));
            cliente.setCanton(results.getString("canton"));
            cliente.setDistrito(results.getString("distrito"));
            cliente.setUbicacion(results.getString("ubicacion"));
            cliente.setEmail(results.getString("email"));
            cliente.setTelefono(results.getString("telefono"));
            cliente.setCodigoPostal(results.getString("codigoPostal"));
            
            clientes.add(cliente);

        }
        
        return clientes;     
    }
    
    public String CrearNuevoCliente(int accion, String identificacion, String nombre, String apellidos, String provincia, String canton, String distrito, String Ubicacion,
                                    String email, String telefono, String codigoPostal){
        ConnectionDB cnDB = new ConnectionDB();
        String respuesta = "";        
            
        String parametros = "" + accion + ", '" + identificacion + "', '" + nombre + "', '" + apellidos + "', '" + provincia + "', '" + canton + "', '" + distrito + "', '"
                            + Ubicacion + "', '" + email + "', '" + telefono + "', '" + codigoPostal + "'";
        
        try{
            ResultSet results = cnDB.ExecuteSP("RiioCR.sp_CrudCliente", parametros);
            respuesta = "OK; Cliente Creado Correctamente";
        } catch(SQLException ex){
            respuesta = "ERROR; " + ex;
        }
        
        return respuesta;
    }
    
}
