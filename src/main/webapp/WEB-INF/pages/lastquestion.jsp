
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit Exam</title>
    </head>
    <body>
        <form:form method="POST" action="submitExam" >
            You have finished your questions. Do you want to send now?
        <br />
        <br />
        <input type="submit" value="Submit" />
        </form:form>
    </body>
</html>
