<%@ include file="common/header.jspf" %>
    <%@ page contentType="text/html; charset=UTF-8" %>
        <%@ include file="common/navigation.jspf" %>

            <div class="container">

                <br>
                <div class="panel panel-primary" style="border-color: cadetblue;">
                    <div class="panel-heading" style="border-color: cadetblue;background-color: cadetblue;">
                        <h3>Mi Perfil</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th width="20%">Nombre</th>
                                    <th width="10%">disponibilidad</th>
                                    <th width="30%"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${users}" var="user">
                                    <tr>
                                        <td width="20%">${user.nombre}</td>
                                        <td width="10%">${user.disponibilidad}</td>
                                        <td width="30%">
                                            <a type="button" class="btn btn-success"
                                                href="/editar-disponibilidad?id=${user.id}" style="background-color: cadetblue;color: white;font-weight: 300;border-radius: 20px;border-color: cadetblue">Editar Disponibilidad</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
            <%@ include file="common/footer.jspf" %>