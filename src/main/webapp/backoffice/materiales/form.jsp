<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialesBackController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

${material}

<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title"></h3>
			 			</div>
			 			<div class="panel-body">
			    		<form role="form">
			    			<div class="form-group">
			    				<input type="number" name="id" class="form-control input-sm" placeholder="id" value=${material.id}>
			    			</div>
			    			<div class="form-group">
			    				<input type="text" name="nombre"class="form-control input-sm" placeholder="Nombre de material" value=${material.nombre}>
			    			</div>
							<div class="form-group">
			    				<input type="text" name="precio" class="form-control input-sm" placeholder="Precio material" value=${material.precio}>
			    			</div>
			    			<div class="row">
			    				<c:if test="${material.id<0}">
			    					<a class="btn btn-success btn-block"href="backoffice/materiales?id=${material.id}&nombre=${material.id}&precio=${material.precio}<%=MaterialesBackController.OP_GUARDAR%>">CREAR</a>
			    				</c:if>
			    			
<%-- 			    				<c:if test="${material.id>=0}"> --%>
				    				<div class="col-xs-6 col-sm-6 col-md-6">
				    					<a class="btn btn-info btn-block" href="backoffice/materiales?id=${material.id}&op=<%=MaterialesBackController.OP_GUARDAR%>">MODIFICAR</a>
				    				</div>
				    				<div class="col-xs-6 col-sm-6 col-md-6">
				    					<a class="btn btn-danger btn-block" href="backoffice/materiales?id=${material.id}&op=<%=MaterialesBackController.OP_ELIMINAR%>">ELIMINAR</a>
				    				</div>
<%-- 				    			</c:if> --%>
			    			</div>
			    		</form>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>




<%@include file="/templates/footer.jsp" %>