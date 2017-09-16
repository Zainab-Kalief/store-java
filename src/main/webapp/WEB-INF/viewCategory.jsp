<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<h2> <c:out value="${ category.name }"/> </h2>

<form method="post" action="/categories/${ category.id }">
	<select name="product">
		<c:forEach items="${ unadded }" var="product">
			<option value=<c:out value="${ product.id }"/> > <c:out value="${ product.name }"/> </option>
		</c:forEach>		
	</select>
	<input type="submit" value="add">
</form>

<div>Categories:
	<c:forEach items="${ category.products }" var="product">
			<p> <c:out value="${ product.name }"/> </p>
	</c:forEach>		
</div>