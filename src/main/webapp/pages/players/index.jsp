<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Players of Emerson's Game</title>
    </head>
    <body>
        <h1>Players</h1>

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
    </body>
</html>
