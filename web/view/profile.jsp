<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) request.getSession().getAttribute("user");%>
<html>
<head>
    <title>Profile</title>
    <jsp:include page="../WEB-INF/ressource.jsp" />
</head>
<body>

<jsp:include page="../WEB-INF/header.jsp" />


<div class="container">
    <div class="jumbotron">
        <div class="row">
            <div class="col-xs-12">
                Bonjour <%= user.getLogin()%>,
                vous pouvez désormais accéder à toutes nos options de création d’URL raccourcies
                Avec mot de passe
                Avec mot de passe différents
                A durée limitée
                A durée périodique
                Création par lots
                Visualisation des statistiques
            </div>

        </div>
    </div>
</div>x



</body>
</html>
