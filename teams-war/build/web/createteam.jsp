<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CreateTeam</title>
    <link rel="stylesheet" href="JoinTeam.css">
    <link rel="stylesheet" href="./styles/NavBar.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js">
</head>
<body>
    <header>
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
<div class="container"style="position:absolute;margin-left:200px;margin-top:50px;">
    <div class="align-items-center">
        
        <div >
            <form action="/teams-war/CreateTeam" method="post" enctype="multipart/form-data">
                <div class="head">
                    <h1>Create team</h1>
    
                </div>
                <div class="row">
                    <!-- First Name -->
                    <div class="input-group col-lg-5 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
                        </div>
                        <input id="Name" type="text" name="name" placeholder="Name" class="form-control bg-white border-left-0 border-md">
                    </div>

                    <br>
                    <div style="position:relative;margin-top:50px;margin-left: 30px;" class="input-group col-lg-7 mb-4">
                      <label class="mr-2">Image:</label>
                      <input type="file" name="image">
                    </div>
                    <hr>
                   
                    
                   <div class="custom-control custom-switch"style="position:absolute;margin-top: 50px;margin-left: 30px;">
                     <input type="checkbox" name="isprivate" class="custom-control-input" id="customSwitch1">
                     <label class="custom-control-label" for="customSwitch1">Private</label>
                   </div>
                   <hr>
                   <div class="input-group col-lg-10 mb-4"style="margin-top: 50px;margin-left: 30px;">
                       <button type="submit" class="btn btn-primary" id="customSwitch1">create</button>
                   </div>
                </div>
            </form>
            <c:if test="${error.error}"><!-- test for errors-->
                <h3><c:out value="${error.errormsg}"/></h3>
            </c:if>
        </div>
    </div>
</div>
<script src="JoinTeam.js"></script>
</body>
</html>