<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>TicTacToe play</title>
</head>
<body>
    <strong>Insert your color codes</strong>
    <f:form method="post" action="/tictactoe/play" commandName="tictactoe">
        <c:forEach items="${tictactoe.fields}" varStatus="counter">
            <f:input path="fields[${counter.index}].content" size="1" maxlength="1" style="text-align: center;" />
            <c:if test="${counter.index%3 == 2}"><br/></c:if>
        </c:forEach>

        <c:choose>
            <c:when test="${tictactoe.finished}">
                <c:if test="${tictactoe.winner}">
                    Gewonnen hat: ${tictactoe.winnerName}
                </c:if>
                <c:if test="${!tictactoe.winner}">
                    Leider hat keiner gewonnen.
                </c:if>
            </c:when>
            <c:otherwise>
                <input type="submit" value="Nächster Zug!"/>
            </c:otherwise>
        </c:choose>
    </f:form>
</body>
</html>