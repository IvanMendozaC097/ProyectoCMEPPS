<%@ include file="common/header.jspf" %>
    <%@ page contentType="text/html; charset=UTF-8" %>
        <%@ include file="common/navigation.jspf" %>

            <div class="container">

                <br>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3>Panel de Usuario</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th width="20%">Email</th>
                                    <th width="20%">Nombre</th>
                                    <th width="10%">password</th>
                                    <th width="10%">disponibilidad</th>
                                    <th width="30%"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${users}" var="user">
                                    <tr>
                                        <td width="20%">${user.email}</td>
                                        <td width="20%">${user.nombre}</td>
                                        <td width="10%">${user.password}</td>
                                        <td width="10%">${user.disponibilidad}</td>
                                        <td width="30%">
                                            <a type="button" class="btn btn-success"
                                                href="/editar-user?id=${user.id}">Editar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
            <%@ include file="common/footer.jspf" %>