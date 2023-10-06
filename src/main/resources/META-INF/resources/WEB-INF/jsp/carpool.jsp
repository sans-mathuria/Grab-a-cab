<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

	<h1>Enter Carpool Details</h1>
	<form:form method="post" modelAttribute="carpool">
		<fieldset class="mb-3">
			<form:label path="source">Source:</form:label>
			<form:input type="text" path="source" required="required"/>
			<form:errors path="source" cssClass="text-warning"/>
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="destination">Destination:</form:label>
			<form:input type="text" path="destination" required="required"/>
			<form:errors path="destination" cssClass="text-warning"/>
		</fieldset>

		<input type="submit" class="btn btn-success"/>

	</form:form>

</div>

<%@ include file="common/footer.jspf" %>