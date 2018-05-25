<%@ page import="model.User" %>
<%@ page import="model.BreizhLink" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) request.getSession().getAttribute("user");%>
<% List<BreizhLink> breizhLinks = (List<BreizhLink>) request.getAttribute("breizhLinks");%>
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

            <div class="col-xs-12">
                <div><%= user.getLogin()%> link's : </div>
                <% for(int i = 0; i < breizhLinks.size(); i++) { %>
                <div>Link raccourci <%= i+1 %> : long : <%= breizhLinks.get(i).getUrl() %> & short : <%= breizhLinks.get(i).getShortUrl() %> & mot de passe : <%= breizhLinks.get(i).getPswd()%></div>
                <% } %>
            </div>

        </div>
    </div>
</div>



</body>
</html>
