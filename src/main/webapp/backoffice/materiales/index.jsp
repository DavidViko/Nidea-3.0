<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialesBackController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>Materiales</h1>
<div class="row">
	<div class="col-md-6">
			<a class="btn btn-outline-primary" href="backoffice/materiales?id=-1&op=<%=MaterialesBackController.OP_MOSTRAR_FORMULARIO%>">Crear Nuevo</a>
		</div>
	<div class="col-md-6">
		<form action="backoffice/materiales" method="get">
			<input type="hidden" name="op" value="<%=MaterialesBackController.OP_BUSQUEDA%>">
			<input type="text" name ="search" placeholder="nombre del material">
			<input type="submit" name="Buscar">
		</form>
	</div>
</div>


<table id="tablaMateriales" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>Id</th>
                
                <th>Nombre</th></a>
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
           	 			<td style='color:blue'> <a href="backoffice/materiales?id=${material.id}&op=<%=MaterialesBackController.OP_MOSTRAR_FORMULARIO%>">${material.nombre}</a></td>
           	 			<td style='color:blue'> ${material.precio} &euro;</td>	
        			</c:when>
        			<c:when test = "${material.precio>=25.0}">
        				<td class='text-danger'> ${material.id}</td>
           	 			<td class='text-danger'> <a href="backoffice/materiales?id=${material.id}&op=<%=MaterialesBackController.OP_MOSTRAR_FORMULARIO%>">${material.nombre}</a></td>
           	 			<td class='text-danger'> ${material.precio} &euro;</td>
        			</c:when>	
					<c:otherwise>
            			<td>${material.id}</td>
            			<td><a href="backoffice/materiales?id=${material.id}&op=<%=MaterialesBackController.OP_MOSTRAR_FORMULARIO%>">${material.nombre}</a></td>
            			<td>${material.precio} &euro;</td>
         			</c:otherwise>
				</c:choose>
				
				</tr>
			</c:forEach>	
        </tbody>
    </table>

<%@include file="/templates/footer.jsp" %>