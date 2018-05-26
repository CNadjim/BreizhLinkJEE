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
                <h3>Bonjour <%= user.getLogin()%></h3>
                vous pouvez désormais accéder à toutes nos options de création d’URL raccourcies
                <ul>
                    <li>Avec mot de passe</li>
                    <li>Avec mot de passe différents</li>
                    <li>A durée limitée</li>
                    <li>A durée périodique</li>
                    <li>Création par lots</li>
                    <li>Visualisation des statistiques</li>
                </ul>
            </div>



        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th></th>
                    <th>Url</th>
                    <th>Short Url</th>
                    <th>Password</th>
                    <th>Date start</th>
                    <th>Date end</th>
                    <th>Max visite</th>
                    <th>Capcha</th>
                    <th>Visite total</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <% for(int i = 0; i < breizhLinks.size(); i++) { %>
                <tr>
                    <td><%= i+1 %></td>
                    <td><%= breizhLinks.get(i).getUrl() %></td>
                    <td><%= breizhLinks.get(i).getShortUrl() %></td>
                    <td><%= breizhLinks.get(i).getPswd() %></td>
                    <td><%= breizhLinks.get(i).getDateStart() %></td>
                    <td><%= breizhLinks.get(i).getDateEnd() %></td>
                    <td><%= breizhLinks.get(i).getMaxVisite() %></td>
                    <td><%= breizhLinks.get(i).isSecured() %></td>
                    <td><%= breizhLinks.get(i).getVisite() %></td>
                    <td>
                        <a href="/breizh/<%= breizhLinks.get(i).getShortUrl() %>" class="btn btn-primary">Accéder</a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>

    </div>
</div>



</body>
</html>
