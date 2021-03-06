<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Login</strong>
                </div>
                <div class="panel-body">
                    <#if errorMessage?? && errorMessage != "">
                        <div class="alert alert-block alert-error bg-danger">${errorMessage}</div>
                    </#if>
                    <form method="POST" action="/login" class="form-signin form-horizontal">
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="input-group input-group-md">
                                    <input class="form-control" name="email" placeholder="Enter email" required="true"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <div class="input-group input-group-md">
                                    <input class="form-control" type="password" name="invitationCode" placeholder="Enter invitation code" required="true"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-default btn-xs">
                                     Submit
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
