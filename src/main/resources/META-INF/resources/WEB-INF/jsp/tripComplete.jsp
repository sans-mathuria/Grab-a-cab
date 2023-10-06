<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Thank you for using GrabACab!</h1>
	<h4>Your driver was : ${driver.username}</h4>
	<a href="pay?id=${driver.id}" class="btn btn-warning">Give Rating to complete</a>
    <!-- <form:form method="post" modelAttribute="driver">
		<fieldset class="mb-3">
			<form:label path="rating">Provide Driver Rating:</form:label>
            <form:input type="number" path="rating" required="required"/>
			<form:errors path="rating" cssClass="text-warning"/>
		</fieldset>

        <input type="hidden" name="driverId" value="${driver.id}">

		<input type="submit" class="btn btn-success"/>

	</form:form> -->

</div>
<%@ include file="common/footer.jspf" %>
