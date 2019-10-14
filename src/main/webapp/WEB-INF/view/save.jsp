<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <style>
        form {
            display: table
        }
        p {
            display: table-row;
        }
        label {
            display: table-cell;
        }
        input {
            display: table-cell;
        }
    </style>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker3.standalone.min.css" />

</head>
<body>
<div class="container-fluid">
    <fmt:setLocale value="RU"/>
    <fmt:setBundle basename="messages" var="i18n"/>
    <form:form modelAttribute="cit" action="save" method="post">
        <div class="row">
            <table width="100%" cellspacing="10" cellpadding="5">
                <tr>
            <td width="300" valign="top">
            <div class="col-6">
                <form:input path="id" cssClass="form-control" type="hidden"/>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label class="col-form-label"><fmt:message bundle="${i18n}" key="cit.city"/></label>
                    <form:input path="city" cssClass="form-control"/>
<%--                    <form:errors path="city" cssStyle="color: red;"/>--%>
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label class="col-form-label"><fmt:message bundle="${i18n}" key="cit.message"/></label>
                    <form:input path="message" cssClass="form-control"/>
<%--                    <form:errors path="message" cssStyle="color: red;"/>--%>
                </div>
            </div>
            </td>
                </tr>
            </table>
        </div>

        <button type="submit" class="btn btn-primary"><fmt:message bundle="${i18n}" key="cit.add"/></button>
    </form:form>
</div>
</body>