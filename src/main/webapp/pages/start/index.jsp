<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Emerson's Game</title>
</head>
<body>
<h1>Start</h1>

    <table id="players">
        <thead>
        <tr>
            <th>Players</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="player" items="${requestScope.players}">
            <tr>
                <td>${player.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button id="btnStart">Start Game</button>
</body>
</html>
