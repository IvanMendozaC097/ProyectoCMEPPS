<%@ include file="common/header.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">Editar tarea</div>
                <div class="panel-body">
                    <form:form method="post" modelAttribute="tarea" action="/actualizar">
                        <form:hidden path="id" />
                        <form:hidden path="semana" />
                        <form:hidden path="mes" />
                        <form:hidden path="anio" />

                        <fieldset class="form-group">
                            <div class="form-group">
                                <form:label path="nombre">Nombre:</form:label>
                                <form:input path="nombre" type="text" class="form-control" required="required" />
                            </div>
                            <div class="form-group">
                                <form:label path="descripcion">Descripción:</form:label>
                                <form:input path="descripcion" type="text" class="form-control" required="required" />
                            </div>
                            <div class="form-group">
                                <form:label path="tiempoEstimado">Tiempo Estimado:</form:label>
                                <form:input path="tiempoEstimado" type="number" class="form-control" required="required" />
                            </div>
                            <div class="form-group">
                                <form:label path="prioridad">Prioridad:</form:label>
                                <form:input path="prioridad" type="number" class="form-control" required="required" />
                            </div>
                            <div class="form-group">
                                <form:label path="completada">Completada:</form:label>
                                <form:checkbox path="completada" />
                            </div>
                        </fieldset>

                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf"%>
