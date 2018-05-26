<%--
  Created by IntelliJ IDEA.
  User: nadjimchabane
  Date: 26/05/2018
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Raccourcir</title>
    <jsp:include page="../WEB-INF/ressource.jsp" />
</head>
<body>
    <jsp:include page="../WEB-INF/header.jsp" />
    <div class="container">
        <div class="jumbotron">
            <div class="row">
                <div class="col-xs-12">
                    <h2>Raccourcir une url avec option</h2>
                    <form method='post' action='shorten' class="form-horizontal">
                        <div class="form-group">
                            <label for="link_url" class="col-sm-3 control-label">URL a raccourcir</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" placeholder="http://example.com" id="link_url" name="link_url">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pswd" class="col-sm-3 control-label">Ajouter un mot de passe</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control"  id="pswd" name="pswd">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="clic" class="col-sm-3 control-label">Maximum de clic</label>
                            <div class="col-sm-9">
                                <input type="number" class="form-control" min="1" id="clic" name="clic">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dateStart" class="col-sm-3 control-label">Valable du</label>
                            <div class="col-sm-3">
                                <input type="date" class="form-control"  id="dateStart" name="dateStart">
                            </div>
                            <label for="dateEnd" class="col-sm-1 control-label">au</label>
                            <div class="col-sm-3">
                                <input type="date" class="form-control"  id="dateEnd" name="dateEnd">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" id="captcha" name="captcha"> Utiliser un captcha
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-default">Raccourcir</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
