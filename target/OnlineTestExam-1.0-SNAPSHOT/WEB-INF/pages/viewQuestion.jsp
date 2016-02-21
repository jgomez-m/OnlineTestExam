<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question</title>
        <spring:url value="/resources/timer.js" var="timerJS" />
        <script src="${timerJS}"></script>
    </head>
    <body>
        <!-- div id="timer">
            This is only valid for the next <input id="minutes" type="text" style="width: 14px; border: none; background-color:none; font-size: 16px; font-weight: bold;"> minutes and <input id="seconds" type="text" style="width: 26px; border: none; background-color:none; font-size: 16px; font-weight: bold;"> seconds.
        </div -->
        <!-- script>
            countdown();
        </script -->
        <div>${questionSelected.description}</div>
        <br />
        <br />
        <form:form action="nextQuestion" method="GET" commandName="choice" >
            
            <c:forEach items="${questionSelected.choiceList}" var="item" >
                <form:radiobutton path="id" value="${item.id}" label="${item.description}" />
                <br />
            </c:forEach>
            
            <br />
            <br />
            <input type="submit" value="Submit"/>
        </form:form>
        <br/>
        <br/>
            Go back to <a href="<c:url value='/viewQuestions' />">List of Questions</a>
    </body>
</html>
