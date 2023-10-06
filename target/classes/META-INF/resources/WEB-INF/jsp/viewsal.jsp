<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h1>Salary</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Driver Id</th>
                    <th>Username</th>
                    <th>Salary</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                    <tr>
                        <td>${drivers.id}</td>
                        <td>${drivers.username}</td>
                        <td>${drivers.salary}</td>
                    </tr>
            </tbody>
        </table>
        
    </div>
    <%@ include file="common/footer.jspf" %>
