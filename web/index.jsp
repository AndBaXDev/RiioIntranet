<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insert definition="MasterPage">
	<tiles:put name="body" value="/welcomeStruts.jsp" />
</tiles:insert>