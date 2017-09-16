<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<body>
	<h2>New Category</h2>
	<form:form method="POST" action="/category/new" modelAttribute="newCategory">
		<form:hidden path="id"/>
     <form:label path="name">Name
     	<form:input path="name"/>
     </form:label><br>
     
      <input type="submit" name="" value="Create">
    </form:form>
</body>
</html>