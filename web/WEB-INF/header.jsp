<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% User user = (User) request.getSession().getAttribute("user");%>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Acceuil</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">

            <% if (!(user == null )) { %>
            <div class="navbar-form navbar-right">
                <a class="btn btn-default" href="/profile/shorten">Raccourcir</a>
                <a class="btn btn-primary" href="/profile">Mon compte</a>
                <a class="btn btn-danger" href="/logout">Deconnexion</a>
            </div>


            <% } else {%>

                <form class="navbar-form navbar-right" style="border-left: 2px solid white;">
                    <a href="/register" class="btn btn-success">Register</a>
                </form>
                <form method='post' action='login' class="navbar-form navbar-right">
                    <div class="form-group">
                        <input type="text" placeholder="id" id="login" name="login" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" id="password"  name="password" placeholder="Password" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-success">Login</button>
                </form>

            <% } %>




        </div><!--/.navbar-collapse -->
    </div>
</nav>
