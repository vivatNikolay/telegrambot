<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-info">
    <div>
        <div class="container-fluid">
            <a href="${pageContext.request.contextPath}/cities/create"><button type="button" class="btn btn-primary btn-lg"><b>Добавить</b></button></a>
                <table class="table">
                    <tr>
                        <div class="col-md-14">
                            <th class="col-md-2">Город</th>
                            <th class="col-md-6">Сообщение</th>
                            <th class="col-md-2"></th>
                            <th class="col-md-2"></th>
                            <th class="col-md-2"></th>
                        </div>
                    </tr>
                    <script>

                    </script>
                    <c:forEach var="showAllCities" items="${showAllCities}" varStatus="status">
                        <tr class="info">
                                <td>${showAllCities.city}</td>
                                <td>${showAllCities.message}</td>
                                <td><a href="${pageContext.request.contextPath}/cities/update?id=${showAllCities.id}"><button type="button" class="btn btn-primary"><b>Обновить</b></button></a></td>
                                <td><a href="${pageContext.request.contextPath}/cities/view?id=${showAllCities.id}"><button type="button" class="btn btn-primary"><b>Посмотреть</b></button></a></td>
                                <td><a href="${pageContext.request.contextPath}/cities/delete?id=${showAllCities.id}"><button type="button" class="btn btn-primary"><b>Удалить</b></button></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</nav>
</body>