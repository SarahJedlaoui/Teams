<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JoinTeam</title>
    <link rel="stylesheet" href="./styles/JoinTeam.css">
    <link rel="stylesheet" href="./styles/NavBar.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js">
</head>
<body>
<header class="header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">  <div class="row"> <img style="height:100px;margin-left: 50px;"src="https://logos-world.net/wp-content/uploads/2021/02/Meetup-Logo.png" class="logo"> </div> </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul  class="navbar-nav">
            <li class="nav-item ">
              <a class="nav-link" href="/teams-war/Teams"><i>Teams</i> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/teams-war/Messages"><i>Messages</i></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/teams-war/Profile"><i>Profile</i></a>
            </li>
            <li style="margin-right: 80px;"class="nav-item">
              <a class="nav-link " href="/teams-war/Logout"><i>Logout</i></a>
            </li>
          </ul>
        </div>
      </nav>
</header>
<div class="container">
    <div class="align-items-center">
        
        <div >
            <form action="/teams-war/JoinTeam" method="post">
                <div class="head">
                    <h1>Join team</h1>
                </div>
                <div class="row">
                    <div class="input-group col-lg-10 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
                        </div>
                        <input id="Name" type="text" name="name" placeholder="Name" class="form-control bg-white border-left-0 border-md">
                    </div>
                    <div class="input-group col-lg-10 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
                        </div>
                        <input id="Code"  name="code" placeholder="Code" class="form-control bg-white border-left-0 border-md">
                    </div>
                    <div class="form-group col-lg-10  mb-0">
                        <button class="btn btn-primary btn-block py-2">Join</button>
                        
                    </div>
                    <div class="form-group col-lg-5 mx-auto d-flex align-items-center my-4">
                        <div class="border-bottom w-100 ml-20"></div>
                        <span class="px-2 small text-muted font-weight-bold text-muted">OR</span>
                        <div class="border-bottom w-100 mr-5"></div>
                    </div>
                    <div class="text-center w-100">
                        <p class="text-muted font-weight-bold"><a href="/teams-war/CreateTeam" class="text-primary ml-2">Create team</a></p>
                        
                    </div>
                    <c:if test="${error.error}">
                        <h3> <c:out value="${error.errormsg}"/></h3>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="JoinTeam.js"></script>
</body>
</html>
