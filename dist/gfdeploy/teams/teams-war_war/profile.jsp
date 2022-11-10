<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="./styles/NavBar.css"> 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js">

</head>
<body>
    <div class="container rounded bg-white mt-5 mb-5">
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
        <div class="row"style="margin-top: 30px;">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="<c:url value="${profile.image}"/>"></div>
            </div>
            <div class="col-md-5 border-right">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">General Informations</h4>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-6"><label class="labels">Name</label><h3><c:out value="${profile.fname}"/></h3></div>
                        <div class="col-md-6"><label class="labels">Surname</label><h3><c:out value="${profile.lname}"/></h3></div>
                    </div>
                    <div class="row mt-3">
                       
                        <div class="col-md-12"><label class="labels">Email</label><h3><c:out value="${profile.email}"/></h3></div>
                      
                    </div>
                  
                </div>
            </div>
            <div class="col-md-4">
                <div class="p-3 py-5">
                    <form action="/teams-war/UpdatePassword" method="post">

                    <div class="col-md-12"><label class="labels">Old password</label><input type="password" name="old" class="form-control" placeholder="old password" value=""></div> <br>
                    <div class="col-md-12"><label class="labels">New password</label><input type="password" name="new" class="form-control" placeholder="new password" value=""></div>
                    <input style="position:relative;margin-left: 120px;margin-top:60px;left:0;"class="btn btn-primary" type="submit" value="Update">
                </form>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
</body>
</html>
