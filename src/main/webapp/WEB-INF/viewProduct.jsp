<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<h2> <c:out value="${ product.name }"/> </h2>

<form method="post" action="/products/${ product.id }">
	<select name="category">
		<c:forEach items="${ unadded }" var="category">
			<option value=<c:out value="${ category.id }"/> > <c:out value="${ category.name }"/> </option>
		</c:forEach>		
	</select>
	<input type="submit" value="add">
</form>

<div>Categories:
	<c:forEach items="${ product.categories }" var="category">
			<p> <c:out value="${ category.name }"/> </p>
	</c:forEach>		
</div>