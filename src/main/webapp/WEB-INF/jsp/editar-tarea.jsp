<%@ include file="common/header.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-primary" style="border-color: cadetblue;">
                <div class="panel-heading" style="border-color: cadetblue;background-color: cadetblue;">Editar tarea</div>
                <div class="panel-body">
                    <form:form method="post" modelAttribute="tarea" action="/actualizar">
                        <form:hidden path="id" />
                        <form:hidden path="semana" />
                        <form:hidden path="mes" />
                        <form:hidden path="anio" />
                        <form:hidden path="completada" />

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
                        </fieldset>

                        <button type="submit" class="btn btn-primary" style="background-color: cadetblue;color: white;font-weight: 300;border-radius: 20px;border-color: cadetblue">Guardar</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf"%>
