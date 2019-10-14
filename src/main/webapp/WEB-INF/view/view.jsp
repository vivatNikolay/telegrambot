<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="col-6">
    <table class="table table-borderless table-striped table-vcenter table-sm">
        <tbody>
        <tr>
            <th>Сведения о городе:</th>
            <td></td>
        </tr>
        <tr>
            <th>Название</th>
            <td>${show.city}</td>
        </tr>
        <tr>
            <th>Сообщение</th>
            <td>${show.message}</td>
        </tr>
        </tbody>
    </table>
</div>
<br>
<div class="col-2 offset-10">
    <a href="${pageContext.request.contextPath}/cities/">
        <button type="button" class="btn btn-secondary">Закрыть</button>
    </a>
</div>
</body>
