<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false" %>
<html>
<head>
    <title>Mastermind play</title>
</head>
<body>
    <strong>Insert your color codes</strong>
    <f:form method="post" action="/mastermind/solution" commandName="CODE">
        <table>
            <tr>
                <td><f:label path="code">Colors</f:label></td>
                <td><f:input path="code" maxlength="4"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Play game - post Colors !"/>
                </td>
            </tr>
        </table>
    </f:form>
</body>
</html>