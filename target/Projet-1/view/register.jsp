<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <jsp:include page="../WEB-INF/ressource.jsp" />
</head>
<body>

<jsp:include page="../WEB-INF/header.jsp" />


<div class="container">
    <div class="jumbotron">
        <div class="row">
            <div class="col-xs-12">
                <h2>S'enregistrer</h2>
                <form method='post' action='register' class="form-horizontal">
                    <div class="form-group">
                        <label for="userName" class="col-sm-2 control-label">UserName</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  id="userName" name="userName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password1" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control"  id="password1" name="password1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password2" class="col-sm-2 control-label">Password Again</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password2" name="password2">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>



</body>
</html>
