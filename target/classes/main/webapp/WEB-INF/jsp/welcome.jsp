<%@ include file="common/header.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common/navigation.jspf"%>
<div class="container">

 <div class="panel panel-primary">
     <div class="panel-heading">P�gina principal</div>
        <div class="panel-body">
           Bienvenido ${name}! <a href="/list-todos">Pulsa aquí</a> para gestionar tus tareas.
        </div>
     </div>
 </div>
<%@ include file="common/footer.jspf"%>