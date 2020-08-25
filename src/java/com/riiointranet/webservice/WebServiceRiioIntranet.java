/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riiointranet.webservice;

import com.riiointranet.business.AccionesCliente;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author andressolanoramirez
 */
@WebService(serviceName = "WebServiceRiioIntranet")
public class WebServiceRiioIntranet {
    
    private AccionesCliente AC = new AccionesCliente();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "InsertarCliente")
    public String ActualizarIdentificacion(@WebParam(name = "identificacion") String identificacion,
                                         @WebParam(name = "nombre") String nombre,
                                         @WebParam(name = "apellidos") String apellidos,
                                         @WebParam(name = "provincia") String provincia,
                                         @WebParam(name = "canton") String canton,
                                         @WebParam(name = "distrito") String distrito,
                                         @WebParam(name = "ubicacion") String ubicacion,
                                         @WebParam(name = "email") String email,
                                         @WebParam(name = "telefono") String telefono,
                                         @WebParam(name = "codigoPostal") String codigoPostal){
        String respuesta;
                
        try {            
            respuesta = AC.CrearNuevoCliente(1, identificacion, nombre, apellidos, provincia, canton, distrito, ubicacion, email, telefono, codigoPostal);
        
            return respuesta;
        } catch (Exception ex) {
            return respuesta = "Error; " + ex;
        }
    }
}
