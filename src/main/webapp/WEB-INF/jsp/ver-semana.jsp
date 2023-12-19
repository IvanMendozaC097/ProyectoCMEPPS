<%@ include file="common/header.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
 <div>
  <a type="button" class="btn btn-primary btn-md" href="/planificar-tareas?semana=${semana}&mes=${mes}&anio=${anio}" style="background-color: cadetblue;color: white;font-weight: 300;border-radius: 20px;border-color: cadetblue">Añadir más Tareas</a>
 </div>
 <br>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-primary" style="border-color: cadetblue;">
                <div class="panel-heading" style="border-color: cadetblue;background-color: cadetblue;">Tareas de la Semana ${semana} del mes ${mes}/${anio}</div>
                <div class="panel-body">
                   <table class="table table-striped">
                      <thead>
                        <tr>
                          <th width="20%">Nombre</th>
                          <th width="30%">Descripción</th>
                          <th width="30%">Tiempo Estimado</th>
                          <th width="20%">Prioridad</th>      
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
                               <a type="button" class="btn btn-danger" href="/cancela-tarea?id=${task.id}&semana=${semana}&mes=${mes}&anio=${anio}">Cancelar</a>
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
