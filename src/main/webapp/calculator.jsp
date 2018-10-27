<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="/calculator" method="post">
    First number: <input type="number" name="firstNumber"/>
    <select name="operator">
        <option>+</option>
        <option>-</option>
    </select>
    Second number: <input type="number" name="secondNumber"/>
    <input type="submit" value="Calculate">
</form>
<c:out value="The result is ${result}"/>
</body>
</html>