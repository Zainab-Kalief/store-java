<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<body>
	<h2>New Product</h2>
	<form:form method="POST" action="/product/new" modelAttribute="newProduct">
		<form:hidden path="id"/>
     <form:label path="name">Name
     	<form:input path="name"/>
     </form:label><br>
     
     <form:label path="description">Description
     	<form:textarea path="description"/>
     </form:label><br>
     
     <form:label path="price">Price
     	<form:textarea path="price"/>
     </form:label><br>
     
      <input type="submit" name="" value="Create">
    </form:form>
</body>
</html>