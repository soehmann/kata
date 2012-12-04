<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false" %>
<html>
<head>
    <title>Mastermind solution</title>
</head>
<body>
    <strong>Your Gameplay</strong><br/>
    <p>
    <c:forEach items="${mastermind.rounds}" var="guess">
        <c:forEach items="${guess.colors}" var="colorCode">[${colorCode.code}]</c:forEach> |
        (<c:forEach items="${guess.pitches}" var="pitch">${pitch.code}</c:forEach>)
    </c:forEach>
    <p/>
    <c:forEach items="${mastermind.colorCodes}" var="colorCode">
        [${colorCode.code}]
    </c:forEach>
    </p>
    <p><a href="/mastermind">play next round</a></p>
</body>
</html>