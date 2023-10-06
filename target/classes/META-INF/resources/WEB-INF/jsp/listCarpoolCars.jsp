<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h1>List of Carpools</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Seating Capacity</th>
                    <th>DriverId</th>
                    <th>Remaining Seats</th>
                    <th>Source</th>
                    <th>Destination</th>

                    <th>Book</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${carpools}" var="carpool">
                    <tr>
                        <td>${carpool.id}</td>
                        <td>${carpool.carCapacity}</td>
                        <td>${carpool.driverId}</td>
                        <td>${carpool.seatsLeft}</td>
                        <td>${carpool.source}</td>
                        <td>${carpool.destination}</td>

                        <!-- <td><a href="book-car?carId=${car.id}&username=${username}" class="btn btn-warning">Book</a></td> -->
                        <td><a href="carpool-details?id=${carpool.id}&isStarted=${carpool.isStarted}&carCapacity=${carpool.carCapacity}&seatsLeft=${carpool.seatsLeft}" class="btn btn-warning">Book a seat</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <%@ include file="common/footer.jspf" %>