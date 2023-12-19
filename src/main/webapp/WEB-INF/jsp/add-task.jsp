<%@ include file="common/header.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<br>
	<div class="panel panel-primary" style="border-color: cadetblue;">
		<div class="panel-heading" style="border-color: cadetblue;background-color: cadetblue;">
			<h3>Añadir Tarea</h3>
		</div>
		<div class="panel-body">
			<form method="post" action="/add-task">
				<div class="form-group">
					<label for="nombre">Nombre:</label> 
					<input type="text" class="form-control"	id="nombre" name="nombre" required>
				</div>
				<div class="form-group">
					<label for="descripcion">Descripción:</label> 
					<input type="text" class="form-control" id="descripcion" name="descripcion" required>
				</div>
				<div class="form-group">
					<label for="tiempoEstimado">Tiempo Estimado:</label> 
					<input type="number" class="form-control" id="tiempoEstimado" name="tiempoEstimado" required>
				</div>
				<div class="form-group">
					<label for="prioridad">Prioridad:</label>
					<input type="number" class="form-control" id="prioridad" name="prioridad" required> <br />
				</div>
				<button class="btn btn-primary" type="submit" style="background-color: cadetblue;color: white;font-weight: 300;border-radius: 20px;border-color: cadetblue">Agregar Tarea</button>
			</form>

		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>