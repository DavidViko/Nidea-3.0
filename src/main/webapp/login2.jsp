<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<div id="login2">

  <form class="form-signin" action="loginUser" method="post">     
	<div class="form-label-group">
        <input type="number" 
               name="id" 
               class="form-control" 
               placeholder="Identificador" required>
               
        <label for="password">Identificador</label>
	</div>
      
      <div class="form-label-group">
        <input type="text" class="form-control"
               name="usuario" 
               placeholder="Nombre Usuario" 
               required autofocus>
               
        <label for="usuario">Nombre Usuario</label>
      </div>

      
     
      <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      
    </form>

</div>
<jsp:include page="templates/footer.jsp"></jsp:include>