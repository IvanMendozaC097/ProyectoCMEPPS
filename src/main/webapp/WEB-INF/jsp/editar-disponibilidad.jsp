<%@ include file="common/header.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-primary" style="border-color: cadetblue;">
                <div class="panel-heading" style="border-color: cadetblue;background-color: cadetblue;">Editar Disponibilidad</div>
                <div class="panel-body">
                    <form:form method="post" modelAttribute="user" action="/actualizar-disponibilidad">
                        <form:hidden path="id" />
                        <form:hidden path="email" />
                        <form:hidden path="password" />
                        <form:hidden path="nombre" />

                        <fieldset class="form-group">
                            <div class="form-group">
                                <form:label path="disponibilidad">Disponibilidad:</form:label>
                                <form:input path="disponibilidad" type="number" class="form-control" required="required" />
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
