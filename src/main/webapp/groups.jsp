<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
    crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ"
    crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

<title>Groups page</title>
</head>
<body>

    <nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">Groups page</a>
        </div>
    </div>

    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="history.back()">previous page</a></li>
            <li><a href="${pageContext.request.contextPath}">main page</a></li>
            <li><a href="${pageContext.request.contextPath}/students">students page</a></li>
        </ul>
    </div>

    </nav>

    <div class="container-fluid">
        <label class="control-label col-sm-3" for="errorMessage">${errorMessage}</label> <br />
        <form class="form-inline" action="${pageContext.request.contextPath}/group">
            <div class="form-group">
                <label for="idGroup">id#</label> <input type="text" class="form-control" id="idGroup" placeholder="Enter Id" name="id">
            </div>
            <button type="submit" class="btn btn-default">Search</button>
        </form>

        <br />

        <table class="table table-hover">
            <tr>
                <th>id</th>
                <th>Title</th>
                <th>Year of entry</th>
            </tr>
            <c:forEach var="group" items="${groups}">
                <tr>
                    <td>${group.id}</td>
                    <td>${group.title}</td>
                    <td>${group.yearEntry}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br />
</body>
</html>
