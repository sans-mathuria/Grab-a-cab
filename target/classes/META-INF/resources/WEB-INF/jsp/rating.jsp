<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<form:form method="post" modelAttribute="driver">
		<fieldset class="mb-3">
			<form:label path="rating">Provide Driver Rating:</form:label>
            <form:input type="number" path="rating" required="required"/>
			<form:errors path="rating" cssClass="text-warning"/>
		</fieldset>

        <input type="hidden" name="driverId" value="${driver.id}">

		<input type="submit" class="btn btn-success"/>

	</form:form>
<%@ include file="common/footer.jspf" %>