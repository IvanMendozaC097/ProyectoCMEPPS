<%@ include file="common/header.jspf" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ include file="common/navigation.jspf" %>

        <div class="container">
            <br>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3>Historial de Tareas</h3>
                </div>
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th width="20%">Nombre</th>
                                <th width="30%">Descripción</th>
                                <th width="30%">Prioridad</th>
                                <th width="20%">Completada</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${tasks}" var="task">
                                <tr>
                                    <td width="20%">${task.nombre}</td>
                                    <td width="30%">${task.descripcion}</td>
                                    <td width="20%">${task.prioridad}</td>
                                    <td width="10%">${task.completada}</td>
                                    <td width="20%">
                                       <a type="button" class="btn btn-danger" href="/cancela-completado?id=${task.id}">No Completada</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
        <%@ include file="common/footer.jspf" %>