
	</div>
	<!--  <div class="container"> -->

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
    
    <script>
		$(document).ready(function() {
	    	$('#tablaMateriales').DataTable({
	    	    "language": {
	    	        "sProcessing":    "Procesando...",
	    	        "sLengthMenu":    "Mostrar _MENU_ registros",
	    	        "sZeroRecords":   "No se encontraron resultados",
	    	        "sEmptyTable":    "Ningún dato disponible en esta tabla",
	    	        "sInfo":          "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	    	        "sInfoEmpty":     "Mostrando registros del 0 al 0 de un total de 0 registros",
	    	        "sInfoFiltered":  "(filtrado de un total de _MAX_ registros)",
	    	        "sInfoPostFix":   "",
	    	        "sSearch":        "Buscar:",
	    	        "sUrl":           "",
	    	        "sInfoThousands":  ",",
	    	        "sLoadingRecords": "Cargando...",
	    	        "oPaginate": {
	    	            "sFirst":    "Primero",
	    	            "sLast":    "Último",
	    	            "sNext":    "Siguiente",
	    	            "sPrevious": "Anterior"
	    	        },
	    	        "oAria": {
	    	            "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	    	            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	    	        }
	    	    }
	    	});
		} );
	</script>
	
  </body>
</html>