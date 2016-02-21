
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Final Grade</title>
    </head>
    <body>
        <p>Your final grade is: ${grade}</p>
        <a href="<c:url value='/login' />">Go to Login page</a>
    </body>
</html>
