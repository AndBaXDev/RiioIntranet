<%-- 
    Document   : LodgingForm
    Created on : Aug 17, 2020, 6:00:58 PM
    Author     : andressolanoramirez
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<div id='body'> 
    <div id="listado" class="div75Percent">
        <table class="table" style="font-size: 12px">
            <thead class="thead-dark">
              <tr>
                <th scope="col">Identificacion</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apellidos</th>
                <th scope="col">Provincia</th>
                <th scope="col">Canton</th>
                <th scope="col">Distrito</th>
                <th scope="col">Ubicacion</th>
                <th scope="col">Email</th>
                <th scope="col">Telefono</th>
                <th scope="col">C. Postal</th>
              </tr>
            </thead>
            <tbody>
                <logic:iterate id="clientes" name="clientes">
                    <tr>
                        <td><bean:write name="clientes" property="identificacion"/></td>
                        <td><bean:write name="clientes" property="nombre"/></td>
                        <td><bean:write name="clientes" property="apellidos"/></td>
                        <td><bean:write name="clientes" property="provincia"/></td>
                        <td><bean:write name="clientes" property="canton"/></td>
                        <td><bean:write name="clientes" property="distrito"/></td>
                        <td style="width:300px;"><bean:write name="clientes" property="ubicacion"/></td>
                        <td><bean:write name="clientes" property="email"/></td>
                        <td><bean:write name="clientes" property="telefono"/></td>
                        <td><bean:write name="clientes" property="codigoPostal"/></td>
                    </tr>
                </logic:iterate>                
            </tbody>
        </table>
    </div>
    <div id="formulario" class="div25Percent" style="padding: 2%; font-size:12px">        
            <h4 style="text-align: center;color: rgba(0,105,152,0.7) !important;">Nuevo Cliente</h4>
            <div class="form-group">
              <label for="txtIdentificacion">Identificación</label>
              <input type="text" class="form-control" id="txtIdentificacion" aria-describedby="identificacionHelp">
              <small id="identificacionHelp" class="form-text text-muted">La identificacion puede ser nacional o extranjero.</small>
            </div>
            <div class="form-group">
              <label for="txtNombre">Nombre</label>
              <input type="text" class="form-control" id="txtNombre">
            </div>            
            <div class="form-group">
              <label for="txtApellido">Apellidos</label>
              <input type="text" class="form-control" id="txtApellido">
            </div>
            <div class="form-group">
              <label for="txtProvincia">Provincia</label>
              <input type="text" class="form-control" id="txtProvincia">
            </div>
            <div class="form-group">
              <label for="txtCanton">Cantón</label>
              <input type="text" class="form-control" id="txtCanton">
            </div>
            <div class="form-group">
              <label for="txtDistrito">Distrito</label>
              <input type="text" class="form-control" id="txtDistrito">
            </div>
            <div class="form-group">
              <label for="txtUbicacion">Ubicación</label>
              <input type="text" class="form-control" id="txtUbicacion">
            </div>
            <div class="form-group">
              <label for="txtEmail">Email</label>
              <input type="email" class="form-control" id="txtEmail">
            </div>
            <div class="form-group">
              <label for="txtTelefono">Teléfono</label>
              <input type="phone" class="form-control" id="txtTelefono">
            </div>
            <div class="form-group">
              <label for="txtCodigoPostal">Código Postal</label>
              <input type="text" class="form-control" id="txtCodigoPostal">
            </div>
            <!--<div class="form-group form-check">
              <input type="checkbox" class="form-check-input" id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>-->
            <button type="submit" class="btn btn-primary" onclick="InsertarCliente()">Crear Cliente</button>        
    </div>
</div>