
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questions Exam</title>
    </head>
    <body>
        
        <h2>Welcome ${candidate} !</h2>
        <p>Please select a question: </p>
        <form:form method="GET" commandName="question" action="viewQuestion">
        <table>
            <tr>
                <td><label>Question: </label> </td>
                <td>
                    
                <form:select path="id">
                        <form:option value="0" label="Select"/>
                        <form:options items="${questionList}" 
                                      itemValue="id" 
                                      itemLabel="description" />
                    </form:select>  
                    
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Select"></td>
            </tr>
        </table>
        </form:form>
    </body>
</html>
