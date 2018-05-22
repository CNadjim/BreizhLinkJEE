<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Titre</title>
    <jsp:include page="../WEB-INF/ressource.jsp" />
  </head>
  <body>

  <jsp:include page="../WEB-INF/header.jsp" />


    <div class="container">
      <div class="jumbotron">
        <div class="row">
          <div class="col-xs-12">
              <form class="form-horizontal">
                <div class="form-group">
                  <label for="url" class="col-sm-2 control-label">URL à raccourcir</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="url">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                      <label>
                        <input type="checkbox"> Sécurisée avec mot de passe
                      </label>
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Raccourcir</button>
                  </div>
                </div>
              </form>
          </div>
          <div class="col-xs-12">
            <h5><a href="register">Créer un compte pour voir nos autres options possibles</a></h5>
          </div>

        </div>
      </div>
    </div>



  </body>
</html>
