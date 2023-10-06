<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h1>Payment</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>RentId</th>
                    <th>CarId</th>
                    <th>Number of days</th>
                    <th>Cost</th>
                </tr>
            </thead>
            <tbody>
                    <tr>
                        <td>${rental.rentalId}</td>
                        <td>${rental.carId}</td>
                        <td>${rental.days}</td>
                        <td>${rental.cost}</td>
                        <td><a href="complete-rental?carId=${rental.carId}" class="btn btn-warning">Pay and Complete</a></td>
                    </tr>
            </tbody>
        </table> 
    </div>
    <%@ include file="common/footer.jspf" %>