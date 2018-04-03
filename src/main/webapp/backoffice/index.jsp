<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>Backoffice</h1>

<%
	// ArrayList<Material> lista = (ArrayList<Material>)request.getAttribute("materiales");
	// Todo esto se sustituye a partir de la version 2.0 del JSP por la EL (Expresion Languaje => ${}
	// Podemos usar cualquier expresion. Si no hay expresion pinta la variable
%>

<ol>
	<c:forEach items="${materiales}" var="material">
		<c:choose>
			<c:when test = "${material.precio>=6.0 && material.precio<25.0}">
            	<li style='color:blue'> ${material.nombre} - ${material.precio} &euro;</li>	
        	 </c:when>
        	 <c:when test = "${material.precio>=25.0}">
            	<li class='text-danger'> ${material.nombre} - ${material.precio} &euro;</li>
        	 </c:when>	
			<c:otherwise>
            	<li>${material.nombre} - ${material.precio} &euro;</li>
         	</c:otherwise>
		</c:choose>
	</c:forEach>
</ol>


<jsp:include page="/templates/footer.jsp"></jsp:include>