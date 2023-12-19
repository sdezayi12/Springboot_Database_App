<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of Data</title>
</head>
<body>
<c:forEach items="${data}" var="item">
    <p>${item.toString()}</p>
</c:forEach>
</body>
</html>