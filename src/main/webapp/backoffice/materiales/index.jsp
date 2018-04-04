<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>Materiales</h1>

<form action="backoffice/materiales" method="get">
	<input type="text" name ="search" placeholder="nombre del material">
	<input type="submit" name="Buscar">

</form>


<table id="tablaMateriales" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Precio</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Precio</th>
            </tr>
        </tfoot>
        <tbody>
        	<c:forEach items="${materiales}" var="material">
				<tr>
				<c:choose>
					<c:when test = "${material.precio>=6.0 && material.precio<25.0}">
           	 			<td style='color:blue'> ${material.id}</td>
           	 			<td style='color:blue'> ${material.nombre}</td>
           	 			<td style='color:blue'> ${material.precio} &euro;</td>	
        			</c:when>
        			<c:when test = "${material.precio>=25.0}">
        				<td class='text-danger'> ${material.id}</td>
           	 			<td class='text-danger'> ${material.nombre}</td>
           	 			<td class='text-danger'> ${material.precio} &euro;</td>
        			</c:when>	
					<c:otherwise>
            			<td>${material.id}</td>
            			<td>${material.nombre}</td>
            			<td>${material.precio} &euro;</td>
         			</c:otherwise>
				</c:choose>
				</tr>
			</c:forEach>	
        </tbody>
    </table>

<%@include file="/templates/footer.jsp" %>