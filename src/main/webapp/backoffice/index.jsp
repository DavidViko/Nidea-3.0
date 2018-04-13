<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<script>
	setTimeout(function(){location.reload(1);},5000);
</script>

<h1>Backoffice</h1>

<table id="tablaMateriales" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th></a>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
            </tr>
        </tfoot>
        <tbody>
			<c:forEach items="${applicationScope.usuariosConectados}" var="usuario">
				<tr>
					<td>${usuario.key}</td>
					<td>${usuario.value}</td>
				</tr>
			</c:forEach>
		</tbody>
    </table>	

<jsp:include page="/templates/footer.jsp"></jsp:include>