/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.riiointranet.struts;

import com.riiointranet.business.AccionesCliente;
import com.riiointranet.domain.Cliente;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author andressolanoramirez
 */
public class ClientesAction extends Action{
    private AccionesCliente AC = new AccionesCliente();
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        clientes = AC.ObtieneClientes();
        
        request.setAttribute("clientes", clientes);
        
        return mapping.findForward("success");        
    }
}
