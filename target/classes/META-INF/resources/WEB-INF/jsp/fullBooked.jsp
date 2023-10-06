<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h1>Carpool started!</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Cost</th>
                </tr>
            </thead>
            <tbody>
                    <tr>
                        <td>${carpool.id}</td>
                        <td>${carpool.cost}</td>
                        <td><a href="complete-carpool?id=${carpool.id}" class="btn btn-warning">Pay and Complete</a></td>
                    </tr>
            </tbody>
        </table> 
    </div>
    <%@ include file="common/footer.jspf" %>