
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h1>List of Cars</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Car Id</th>
                    <th>Model</th>
                    <th>Color</th>
                    <th>Seating Capacity</th>
                    <th>Available For Booking?</th>
                    <th>Book</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cars}" var="car">
                    <tr>
                        <td>${car.id}</td>
                        <td>${car.model}</td>
                        <td>${car.color}</td>
                        <td>${car.seatingCapacity}</td>
                        <td>${car.availableForBooking}</td>
                        <td><a href="rent-details?carId=${car.id}" class="btn btn-warning">Book</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="common/footer.jspf" %>
