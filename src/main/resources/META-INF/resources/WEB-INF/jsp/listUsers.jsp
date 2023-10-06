<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
    <div class="container">
        <!-- <h1>List of Users</h1> -->
        <!-- <table class="table">
            <thead>
                <tr>
                    <th>Driver Id</th>
                    <th>Username</th>
                    <th>Assigned CarId</th>
                    <th>Driver Rating</th>
                    <th>Salary</th>
                    <th>Delete</th>
                    <th>Used Cars</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${driver.username}</td>
                        <td>${driver.assignedCarId}</td>
                        <td>${driver.rating}</td> -->
                        <!-- <td><a href="get-salary?id=${driver.id}" class="btn btn-warning">Salary</a></td>
                        <td><a href="delete-driver?id=${driver.id}" class="btn btn-warning">Delete</a></td>
                        <td><a href="driver/used-cars?driverId=${driver.id}" class="btn btn-warning">Used Cars</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>  -->
        <!-- <a href="add-driver" class="btn btn-success">Add Driver</a> -->
        <a href="add-user" class="btn btn-success">Add User</a>
    </div>
    <%@ include file="common/footer.jspf" %>