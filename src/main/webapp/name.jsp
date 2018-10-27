<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="/name" method="post">
    Name: <input type="text" name="name"/>
    <input type="submit" value="Send">
</form>
Hi <c:out value="${name}"/>
</body>
</html>