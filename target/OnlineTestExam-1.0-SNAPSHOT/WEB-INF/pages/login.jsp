<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>

        <style>

            .error {
                color: #ff0000;
            }
        </style>

    </head>
    <body>
        <h2>Login Page</h2>
        
        <p>Purpose of the exam:</p>
        <p>${examDescription}</p>
        <br />
        <form:form method="POST" action="/OnlineTestExam/login" modelAttribute="candidate">
            <table>
                <tr>
                    <td><label for="name">Username: </label> </td>
                    <td><form:input path="username" id="username"/></td>
                    <td><form:errors path="username" cssClass="error"/></td>
                </tr>

                <tr>
                    <td><label for="password">Password: </label> </td>
                    <td><form:password path="password" id="password"/></td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>

                <tr>
                    <td colspan="3">
                        <input type="submit" value="Log-in"/>
                    </td>
                </tr>
            </table>
        </form:form>

    </body>
</html>
