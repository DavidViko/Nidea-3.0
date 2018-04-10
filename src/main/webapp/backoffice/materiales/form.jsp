<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialesBackController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<div class="container">
	
	<div class="form-group row">
		<a class="btn btn-outline-dark btn-lg" href="backoffice/materiales">Volver</a>
	</div>

	<div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    	<h3 class="panel-title"></h3>
			 	</div>
			 	<div class="panel-body">
			    	<form role="form" action="backoffice/materiales">
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
			    				<input type="hidden" name="op" value="<%=MaterialesBackController.OP_GUARDAR%>">
			    				<button type="submit" class="btn btn-primary btn-lg btn-block">CREAR</button>
			    			</c:if>
			    			
 			    			<c:if test="${material.id>=0}"> 
				    			<div class="col-xs-6 col-sm-6 col-md-6">
				    				<input type="hidden" name="op" value="<%=MaterialesBackController.OP_GUARDAR%>"> 
				    				<input class="btn btn-info btn-block" type="submit" value ="MODIFICAR">
				    			</div>
				    			<div class="col-xs-6 col-sm-6 col-md-6" >
				    				<button type="button" class="btn btn-danger btn-block" data-toggle="modal" data-target="#miModal">ELIMINAR </button>
				    			</div>
				    			
				    			<!-- Modal -->
								<div class="modal fade" id="miModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <h5 class="modal-title" id="exampleModalLabel">PRECAUCION</h5>
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
								          <span aria-hidden="true">&times;</span>
								        </button>
								      </div>
								      <div class="modal-body">
								        ¿Seguro que quieres borrarlo?
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
								        <a class="btn btn-danger" href="backoffice/materiales?id=${material.id}&op=<%=MaterialesBackController.OP_ELIMINAR%>">CONFIRMAR</a>
								      </div>
								    </div>
								  </div>
								</div><!-- fin Modal -->
								
 				    		</c:if>
			    		</div>
			    	</form>
			    </div>
	    	</div>
    	</div>
	</div>
</div>

<%@include file="/templates/footer.jsp" %>