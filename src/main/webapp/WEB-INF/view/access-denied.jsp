<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Access denied</title>
</head>

<body>

 <h2> Access Denied- you are not authorized to access this resource</h2>
 
 <hr>
 
 <a href="${pageContext.request.contextPath}/">Back to home page</a>

</body>
</html>