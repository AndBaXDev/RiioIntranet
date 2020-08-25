/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// *********** Acciones generales ***********//

var aplicationName = "RiioIntranet";

function FindByTextInTableIndexes(inputId, tableId, indexes) {
    var input, filter, table, tr, td, i, txtValue, index;
    input = document.getElementById(inputId);
    filter = input.value.toUpperCase();
    table = document.getElementById(tableId);    
    var maxIndex = indexes.split(",").length;
    
    tr = table.getElementsByTagName("tr");
    for (i = 1; i < tr.length; i++) {        
        var encontrados = 0;
        for(index = 0; index <= maxIndex; index++){
            td = tr[i].getElementsByTagName("td")[index];
            
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    encontrados = encontrados + 1;
                }
            }
            
            if(encontrados > 0){
                tr[i].style.display = "";
            }else{
                tr[i].style.display = "none";
            }
        }
               
    }
}

function FindByTextInTableIndex(inputId, tableId, index) {    
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById(inputId);
    filter = input.value.toUpperCase();
    table = document.getElementById(tableId);
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[index];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tr[i].style.display = "";
            } else {
            tr[i].style.display = "none";
            }
        }       
    }
}

function FindByTextInTable(inputId, tableId) {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById(inputId);
    filter = input.value.toUpperCase();
    table = document.getElementById(tableId);
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tr[i].style.display = "";
            } else {
            tr[i].style.display = "none";
            }
        }       
    }
}

function CambioItemMenu(idItem){    
    $("ul.nav li").siblings().removeClass("active");
    $("#" + idItem).addClass("active");
};

function MuestraFuncionalidad(pagina, permiso){    
    if(pagina === "identificaciones.do"){                  
        if(permiso === "1"){
            $("#btnAgregarIdent").removeClass("ocultar");
        }else if(permiso === "2"){            
            MuestraItemsDeTabla('tableIdentifications','btnEditarIdent_');
        }else if(permiso === "4"){
            MuestraItemsDeTabla('tableIdentifications','btnReemplazarArchivo_');            
        }else if(permiso === "3"){
            MuestraItemsDeTabla('tableIdentifications','btnEliminarIdent_');            
        }else if(permiso === "8"){
            MuestraColumnaDeTabla('tableIdentifications', 10);
        }
    }if(pagina === "Becas.do"){
         if(permiso === "5"){
            $("#btnInsertarBeca").removeClass("ocultar");
        }else if(permiso === "6"){            
            MuestraItemsDeTabla('tableIdentifications','btnEditarBeca_');
        }else if(permiso === "7"){
            MuestraItemsDeTabla('tableIdentifications','btnEliminarBeca_');                    
        }else if(permiso === "9"){
            MuestraColumnaDeTabla('tableIdentifications',12);                    
        }
    }if(pagina === "ControlUsuarios.do"){
         if(permiso === "10"){
            $("#ControlUsuarios").removeClass("ocultar");
        }
    }
}

function MuestraColumnaDeTabla(tableName, indice){    
    var table = document.getElementById(tableName);
    var tr = table.getElementsByTagName("tr");
    var td, i;    
    for (i = 0; i < tr.length; i++) {
        
        if(i === 0){
            td = tr[i].getElementsByTagName("th")[indice];
            td.classList.remove('ocultar');
        }else{
            td = tr[i].getElementsByTagName("td")[indice];
            td.classList.remove('ocultar');
        }
    }
}

function MuestraItemsDeTabla(tableName, boton){
    var table = document.getElementById(tableName);
    var tr = table.getElementsByTagName("tr");
    var td, i;
    for (i = 1; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];                                
        $("#"+boton+td.innerHTML.trim()).removeClass("ocultar");
    }
}
/* ---- Acciones Identificaciones -- */

function ClearDatesFilters(startDate, finishDate){
    $("#" + startDate).val("");
    $("#" + finishDate).val("");
    location.reload();
}

function ClearIdent(){    
    $("#numOficio").removeAttr('disabled');    
    $("#tModalId").text("Nuevo");
    $("#numOficio").val("");
    $("#fechaDocumento").val("");
    $("#fechaIngreso").val("");
    $("#unidadOrigen").val("");
    $("#remitente").val("");
    $("#descripcion").val("");
    $("#destinatario").val("");
    $("#ubicacionArchivo").val("");
    $("#rutaArchivo").val("");
    //$("#ubicacionArchivo").val("");
    $("fechaIngresoText").val("");
    $("fechaDocumentoText").val("");
    
    $("#checkEsCopia").attr("checked", false);
    
    $("#uploadFileField").removeClass('ocultar');
    
    $("#btnGuardarIdentificacion").attr('onClick', 'InsertarIdentificacion()');
}
/* ---- FIN Acciones Identificaciones -- */
/* ---- Acciones Clientes -- */
function BuscaBecasXFechas(tableName){    
    $("#"+tableName + " tbody > tr").remove();
    //
    alert("fecha desde: " + $("#fechaUltimoRegistroDesde").val() + " / fecha hasta: " + $("#fechaUltimoRegistroHasta").val());
    $.ajax({
        type: "GET",
        url: "ActualizaBeca.do",
        data: {fechaUltimoRegistroDesde: $("#fechaUltimoRegistroDesde").val(), fechaUltimoRegistroHasta: $("#fechaUltimoRegistroHasta").val()},
        dataType: 'json',
        success: function(respJson){            
            for(var i in respJson){                
                var beca = respJson[i];                
                $("#"+tableName + " tbody").append(
                    "<tr>" +
                        "<td>"+beca.idIB+"</td>"+
                        "<td>"+beca.nombreBecario+"</td>"+
                        "<td>"+beca.apellido1+"</td>"+
                        "<td>"+beca.apellido2+"</td>"+
                        "<td>"+beca.identificacion+"</td>"+
                        "<td>"+beca.unidadAcademica+"</td>"+
                        "<td>"+beca.periodoDesde+"</td>"+
                        "<td>"+beca.periodoDesde+"</td>"+
                        "<td>"+beca.pais+"</td>"+
                        "<td>"+beca.estado+"</td>"+
                        "<td>"+beca.unidad+"</td>"+
                        "<td>"+beca.observaciones+"</td>"+                        
                        "<td>"+beca.usuario+"</td>"+                        
                        "<td>" +
                        "<button type='button' style='padding:0;' class='btn btn-link' onclick=\"LoadEditBeca('"+ beca.idIB +"','"+ beca.nombreBecario +"','"+beca.apellido1+"','"+beca.apellido2+"', '"+beca.identificacion+"','"+beca.unidadAcademica+"','"+beca.periodoDesde+"', '"+beca.periodoHasta+"', '"+beca.pais+"', '"+beca.estado+"', '"+beca.unidad+"', '"+beca.observaciones+"')\">" +
                            "<i class='material-icons' style='color:lightblue'>edit</i>"+
                        "</button>"+
                        "<button type='button' style='padding:0;' class='btn btn-link' onclick=\"EliminarBeca('"+ beca.idIB+"')\">"+
                            "<i class='material-icons' style='color:red'>delete_forever</i>"+
                        "</button>" +
                        "</td>" +
                    "</tr>"
                );                
            }
        },
        error: function(r){
            NotificacionError('ERROR: ' + r.responseText, 5);   
        }
    });
}

function ClearBeca(){
    $("#idIBTitle").text("");
    $("#tModalId").text("Nueva Beca");
    $("#indentificacion").val("");
    $("#nombreBecario").val("");
    $("#apellido1").val("");
    $("#apellido2").val("");
    $("#unidadAcademica").val("");
    $("#unidad").val("");
    $("#periodoDesde").val("");
    $("#periodoHasta").val("");
    $("#pais").val("");
    $("#estado").val("");
    $("#observaciones").val("");
    
    $("#btnGuardarBeca").attr('onClick', 'InsertarBeca()');
}

function LoadEditBeca(idIB, nombreBecario, apellido1, apellido2, identificacion, unidadAcademica, periodoDesde, periodoHasta, pais, estado, unidad, observaciones){    
    alert("Entra al metodo");
    $("#idIBTitle").text(idIB);
    $("#tModalId").text("Editar");
    $("#prueba").val(identificacion);
    $("#apellido1").val(apellido1);
    $("#nombreBecario").val(nombreBecario);
    $("#apellido2").val(apellido2);
    $("#unidadAcademica").val(unidadAcademica);
    $("#periodoDesde").val(periodoDesde);
    $("#unidad").val(unidad);
    $("#periodoHasta").val(periodoHasta);
    $("#pais").val(pais);
    $("#estado").val(estado);
    $("#unidad").val(unidad);
    $("#observaciones").val(observaciones);    
    
    $("#btnGuardarBeca").attr('onClick', 'ActualizarBeca()');
                
    $("#modalBecas").modal('toggle');    
}

function InsertarCliente(){            
    var valido;        
    $.ajax({
        type: "POST",
        url: "Cliente_ObieneTodos_Inserta.do",
        data: {identificacion: $("#txtIdentificacion").val(), 
               nombre: $("#txtNombre").val(), 
               apellidos: $("#txtApellido").val(), 
               provincia: $("#txtProvincia").val(), 
               canton: $("#txtCanton").val(), 
               distrito: $("#txtDistrito").val(), 
               ubicacion: $("#txtUbicacion").val(), 
               email: $("#txtEmail").val(), 
               telefono: $("#txtTelefono").val(), 
               codigoPostal: $("#txtCodigoPostal").val()               
              },
        success: function(r){
            valido = r.split(";")[1].trim();                      
            MensajeOKRefreshButton("Cliente registrado",r);
            location.reload();           
        },
        error: function(r){
           alert('ERROR' + r); 
        }
    });
    
}

function ActualizarBeca(){        
    //alert('Entra a actualizar la beca, idBeca: ' + $("#idIBTitle").text());
    var user = sessionStorage.getItem('usuario');    
    alert("El usuario es: " + user);
    var periodoDesde01 = $("#periodoDesdeText").val() + '/01';    
    var periodoHasta01 = $("#periodoHastaText").val() + '/01';
    $.ajax({
        type: "POST",
        url: "ActualizaBeca.do",
        data: {idIB: $("#idIBTitle").text(), nombreBecario: $("#nombreBecario").val(), apellido1: $("#apellido1").val(), apellido2: $("#apellido2").val(), identificacion: $("#prueba").val()
              ,unidadAcademica: $("#unidadAcademica").val(), periodoDesde: periodoDesde01, periodoHasta: periodoHasta01, pais: $("#pais").val()
              ,estado: $("#estado").val(), unidad: $("#unidad").val(), observaciones: $("#observaciones").val(), usuario: user},
        success: function(r){
            var valido = r.split(";")[0].trim();            
            if(valido === "ERROR"){
                NotificacionError(r.split(";")[1].trim(), 10);
            }else{
                MensajeOKRefreshButton('Registro Actualizado', r);
            }
        },
        error: function(r){
           NotificacionError(r.responseText, 5);
        }
    });
}

function EliminarBeca(vidIB){
     $.ajax({
        type: "POST",
        url: "EliminarBeca.do",
        data: {idIB: vidIB},
        success: function(r){
           MensajeOKRefreshButton('Beca Eliminada', r);
           location.reload();
        },
        error: function(r){
            NotificacionError(r.responseText, 5);
        }
    });
}
/* ---- FIN Acciones Becas -- */

// ---- Mensajes y Notificaciones ----
function MensajeOK(titulo, mensaje){
    alertify.alert().set({transition:'zoom',message: mensaje, title: titulo}).show();     
}

function MensajeOKRefreshButton(titulo, mensaje){    
    alertify.alert().set({
            transition:'zoom',message: mensaje, title: titulo,
            onok: function(closeEvent){ location.reload();}
        }).show();
}

function NotificacionExitoso(mensaje, duration){   
    alertify.set('notifier','position', 'top-right');
    var msg = alertify.success(mensaje+' | ' + duration + ' seconds.', duration, function(){ clearInterval(interval);});
    var interval = setInterval(function(){
       msg.setContent(mensaje+' | '+(--duration)+' seconds.');
    },1000);
}

function NotificacionError(mensaje, duration){   
    alertify.set('notifier','position', 'top-right');
    var msg = alertify.error(mensaje+' | ' + duration + ' seconds.', duration, function(){ clearInterval(interval);});
    var interval = setInterval(function(){
       msg.setContent(mensaje+' | '+(--duration)+' seconds.');
    },1000);
}

function NotificacionInfo(mensaje, duration){    
    alertify.set('notifier','position', 'top-right');
    var msg = alertify.message(mensaje+' | ' + duration + ' seconds.', duration, function(){ clearInterval(interval);});
    var interval = setInterval(function(){
       msg.setContent(mensaje+' | '+(--duration)+' seconds.');
    },1000);
}
