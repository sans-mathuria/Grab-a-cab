<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<h1>Enter Rental Details</h1>
    <form:form method="post" modelAttribute="rental">
		<fieldset class="mb-3">
			<form:label path="days">Number of days:</form:label>
			<form:input type="text" path="days" required="required"/>
			<form:errors path="days" cssClass="text-warning"/> 
		</fieldset>

		<input type="submit" class="btn btn-success"/>

	 </form:form> 
 	
</div>
<%@ include file="common/footer.jspf" %> 