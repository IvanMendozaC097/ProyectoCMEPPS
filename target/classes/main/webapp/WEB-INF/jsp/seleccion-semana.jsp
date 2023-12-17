<%@ include file="common/header.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">Selecciona Semana</div>
                <div class="panel-body">
                    <form method="post" action="/seleccion-semana">
                        <div class="form-group">
                            <label for="semana">Semana:</label>
                            <select class="form-control" id="semana" name="semana" required>
                                <c:forEach var="i" begin="1" end="4">
                                    <option value="${i}">${i}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="mes">Mes:</label>
                            <select class="form-control" id="mes" name="mes" required>
                                <c:forEach var="i" begin="1" end="12">
                                    <option value="${i}">${i}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="anio">Año (>=2023):</label>
                            <input type="number" class="form-control" id="anio" name="anio" required>
                        </div>
                        <button type="submit" class="btn btn-success">Seleccionar Semana</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf"%>





