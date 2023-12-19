<%@ include file="common/header.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
 <div>
  <a type="button" class="btn btn-primary btn-md" href="/ver-semana?semana=${semana}&mes=${mes}&anio=${anio}" style="background-color: cadetblue;color: white;font-weight: 300;border-radius: 20px;border-color: cadetblue">Tareas de esta semana</a>
 </div>
 <br>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-primary" style="border-color: cadetblue;">
                <div class="panel-heading" style="border-color: cadetblue;background-color: cadetblue;">Planificar Semana ${semana} del mes ${mes}/${anio} ----- Tiempo Libre Restante de la semana: ${tmax}</div>
                <div class="panel-body">
                   <table class="table table-striped">
                      <thead>
                        <tr>
                          <th width="20%">Nombre</th>
                          <th width="30%">Descripción</th>
                          <th width="10%">Tiempo Estimado</th>
                          <th width="10%">Prioridad</th>      
                          <th width="30%"></th>
                       </tr>
                     </thead>
                     <tbody>
                       <c:forEach items="${tasks}" var="task">
                        <tr>
                           <td width="20%">${task.nombre}</td>
                           <td width="30%">${task.descripcion}</td>
                           <td width="10%">${task.tiempoEstimado}</td>
                           <td width="10%">${task.prioridad}</td>
                           <td width="30%">
                               <a type="button" class="btn btn-success" href="/planificar-task?id=${task.id}&semana=${semana}&mes=${mes}&anio=${anio}">Seleccionar</a>
                          </td>
                        </tr>
                      </c:forEach>
                  </tbody>
	   			</table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf"%>
