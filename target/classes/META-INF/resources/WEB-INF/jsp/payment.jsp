<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h1>Payment</h1>
        <!--<h2>tripid=</h2><h2>${trip.tripid}</h2> -->
        <!-- <h2>source=</h2><h2>${trip.source}</h2> -->
        <table class="table">
            <thead>
                <tr>
                    <th>TripId</th>
                    <th>DriverId</th>
                    <th>CarId</th>
                    <th>Cost</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${trips}" var="trip">
                    <tr>
                        <td>${trip.tripid}</td>
                        <td>${trip.driverId}</td>
                        <td>${trip.carId}</td>
                        <td>${trip.cost}</td>
                        <td><a href="trip-complete?driverId=${trip.driverId}" class="btn btn-warning">Complete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table> 
    </div>
    <%@ include file="common/footer.jspf" %>