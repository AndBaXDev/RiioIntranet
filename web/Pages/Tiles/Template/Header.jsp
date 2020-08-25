<!--<div style="padding:16px;background-color:red">
<h1>[Logo Here] This is Template Red Header</h1>
</div> -->
<!-- <div style="padding:16px;background-color:green">
<h1>[Logo Here] This is Template Green Header</h1>
</div> -->

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<header>
<!--<div class="bg-warning py-3 colorMenu">
	<div class="container">
            <picture>
                <source media="(max-width: 767px)" srcset="https://cdn.galaxy.tf/thumb/sizeW500/uploads/3s/cms_image/001/535/133/1535133731_5b8048230be2c-thumb.png">
                <img class="header__logo js-header-logo-height" src="https://cdn.galaxy.tf/thumb/sizeW500/uploads/3s/cms_image/001/535/475/1535475046_5b857d663d3e5-thumb.png" alt>
            </picture>
	</div>
</div>-->
<div class="navbar-wrap">
	<nav id="navbar_top" class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container">
                <picture>
                    <source media="(max-width: 767px)" srcset="./Images/6X6_Angel_RIIO.png">
                    <img class="header__logo js-header-logo-height" src="./Images/6X6_Angel_RIIO.png" alt width="100px" height="100px">
                </picture>                
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main_nav" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="main_nav">

                    <ul class="navbar-nav ml-auto">
                            <li class="nav-item"><a class="nav-link" href="./Welcome.do"> <bean:message key="menu.home"/> </a></li>
                            <li class="nav-item"><a class="nav-link" href="./Clientes.do"> <bean:message key="menu.clientes"/> </a></li>
                            <li class="nav-item"><a class="nav-link" href="./Lodging.do"> <bean:message key="menu.ventas"/> </a></li>                                                        
                            <!--<li class="nav-item dropdown">
                                <a class="nav-link  dropdown-toggle" href="#" data-toggle="dropdown"> <i style="font-size:14px" class="fa">&#xf2b4;</i> </a>
                                <ul class="dropdown-menu dropdown-menu-right">
                                    <li style="text-align:center"><a class="dropdown-item nav-link" href="#"><html:link page="/Locale.do?method=espanol"><bean:message key="idioma.espanol"/></html:link></a></li>
                                    <li style="text-align:center"><a class="dropdown-item nav-link" href="#"><html:link page="/Locale.do?method=english"><bean:message key="idioma.ingles"/></html:link></a></li>
                                </ul>
                            </li>-->                            
                    </ul>

                </div> <!-- navbar-collapse.// -->
            </div> <!-- container.// -->
	</nav>
</div>
</header>
</script>