<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
 <div>
  <a type="button" class="btn btn-primary btn-md" href="/add-todo">Añadir tarea</a>
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>Lista de tareas</h3>
  </div>
  <div class="panel-body">
   <table class="table table-striped">
    <thead>
     <tr>
     <th width="20%">Nombre</th>
     <th width="20%">Descripción</th>
     <th width="20%">Nombre</th>
     <th width="20%">Descripción</th>
     <th width="20%">Nombre</th>
      
      <th width="20%"></th>
     </tr>
    </thead>
    <tbody>
     <c:forEach items="${tasks}" var="task">
        <tr>
            <td>${task.nombre}</td>
            <td>${task.descripcion}</td>
            <td>${task.tiempoEstimado}</td>
            <td>${task.prioridad}</td>
            <td>${task.completada}</td>
            <td>
                <a type="button" class="btn btn-success" href="/update-todo?id=${task.id}">Editar</a>
                <a type="button" class="btn btn-warning" href="/delete-todo?id=${task.id}">Borrar</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
   </table>
  </div>
 </div>

</div>
<%@ include file="common/footer.jspf"%>