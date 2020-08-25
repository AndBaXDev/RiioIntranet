/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riiointranet.controllerws;

import com.riiointranet.WS.WebServiceRiioIntranet_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author andressolanoramirez
 */
@WebServlet(name = "Cliente_ObieneTodos_Inserta", urlPatterns = {"/Cliente_ObieneTodos_Inserta.do"})
public class Cliente_ObieneTodos_Inserta extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/RIIOIntranet/WebServiceRiioIntranet.wsdl")
    private WebServiceRiioIntranet_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cliente_ObieneTodos_Inserta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cliente_ObieneTodos_Inserta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensaje;
        mensaje = insertarCliente(request.getParameter("identificacion"), request.getParameter("nombre"), request.getParameter("apellidos"), 
                                  request.getParameter("provincia"), request.getParameter("canton"), request.getParameter("distrito"), 
                                  request.getParameter("ubicacion"), request.getParameter("email"), request.getParameter("telefono"), 
                                  request.getParameter("codigoPostal"));
        response.setContentType("text/plain");
        response.getWriter().write(mensaje);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String insertarCliente(java.lang.String identificacion, java.lang.String nombre, java.lang.String apellidos, java.lang.String provincia, java.lang.String canton, java.lang.String distrito, java.lang.String ubicacion, java.lang.String email, java.lang.String telefono, java.lang.String codigoPostal) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.riiointranet.WS.WebServiceRiioIntranet port = service.getWebServiceRiioIntranetPort();
        return port.insertarCliente(identificacion, nombre, apellidos, provincia, canton, distrito, ubicacion, email, telefono, codigoPostal);
    }
    
    

}
