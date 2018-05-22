<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>
    <jsp:include page="../WEB-INF/ressource.jsp" />
  </head>
  <body>

  <jsp:include page="../WEB-INF/header.jsp" />


    <div class="container">
      <div class="jumbotron">
        <div class="row">
          <div class="col-xs-12">

              <form method='post' action='breizh' class="form-horizontal">
                <div class="form-group">
                  <label for="link_url" class="col-sm-2 control-label">URL à raccourcir</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="http://example.com" id="link_url" name="link_url">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                      <label>
                        <input type="checkbox" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample"> Sécurisée avec mot de passe
                      </label>
                    </div>
                    <div class="collapse" id="collapseExample">
                      <div class="form-group">
                        <div class="col-sm-12">
                          <input type="text" placeholder="password" id="link_password" name="link_password" class="form-control">
                        </div>
                      </div>
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
