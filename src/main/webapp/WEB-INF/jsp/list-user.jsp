<%@ include file="common/header.jspf" %>
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
                                <th width="30%">Password</th>
                                <th width="10%">Disponibilidad</th>
                                <th width="10%">Nombre</th>
                                <th width="30%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td width="20%">${user.email}</td>
                                    <td width="30%">${user.password}</td>
                                    <td width="10%">${user.disponibilidad}</td>
                                    <td width="10%">${user.nombre}</td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
        <%@ include file="common/footer.jspf" %>