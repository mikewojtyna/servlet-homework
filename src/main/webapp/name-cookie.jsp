<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="/name-cookie" method="post">
    Name: <input type="text" name="name" value="${nameAttrFromCookie}"/>
    <input type="submit" value="Send">
</form>
</body>
</html>