<%@ include file="common/header.jspf"%>
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
                            </select>                        </div>
                        <div class="form-group">
                            <label for="mes">Mes:</label>
                            <select class="form-control" id="mes" name="mes" required>
                              <c:forEach var="i" begin="1" end="12">
                                  <option value="${i}">${i}</option>
                              </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="año">Año:</label>
                            <input type="number" class="form-control" id="año" name="año" required>
                        </div>
                        <button class="btn btn-primary" type="submit">Seleccionar semana</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jspf"%>


