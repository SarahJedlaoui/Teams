<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="user.css">
    <title>Teams</title>
    <link rel="stylesheet" href="./styles/NavBar.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js">

    
</head>
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
              <a class="nav-link " href="#"><i>Logout</i></a>
            </li>
          </ul>
        </div>
      </nav>
</header>
<body>
    <div class="container mt-3">
        <span style="position:absolute;margin-left:150px;top:0;margin-top: 100px;"><h4>Search for teams</h4></span>
        <div style="bottom:0;margin-top: 100px;"class="row d-flex justify-content-center">
            <nav style="top:0;position:absolute;margin-top: 150px;"class="navbar navbar-light bg-light">
              
                <form class="form-inline">
                   
                  <input style="width:620px;"class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
                <div class="dropdown">
  <div aria-labelledby="Options">
    <a class="btn btn-primary" href="/teams-war/JoinTeam">Join Team</a>
    <a class="btn btn-primary" href="/teams-war/CreateTeam">Create Team</a>
  </div>
</div>
              </nav> 
              <div style="top:0;margin-top: 150px;"class="card-deck">
                <div class="card">
                  <img class="card-img-top" style="width:250px;height:300px;"src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg" alt="Card image cap">
                  <div class="card-body"style="left:0;margin-left:40px;">
                    <h5 class="card-title"style="margin-left:45px;">Team</h5>
                   <a href="#" style="margin-left:20px;width:100px;"class="btn btn-primary">Join</a>
                  </div>
                </div>
                <div class="card">
                  <img class="card-img-top" style="width:250px;height:300px;"src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg" alt="Card image cap">
                  <div class="card-body"style="left:0;margin-left:40px;">
                    <h5 class="card-title"style="margin-left:45px;">Team</h5>
                    <a href="#"style="margin-left:20px;width:100px;" class="btn btn-primary">Join</a>
                  </div>
                </div>
                <div class="card">
                  <img class="card-img-top"style="width:250px;height:300px;" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"alt="Card image cap">
                  <div class="card-body"style="left:0;margin-left:40px;">
                    <h5 class="card-title"style="margin-left:45px;">Team</h5>
                    <a href="#" style="margin-left:20px;width:100px;"class="btn btn-primary">Join</a>
                    
                  </div>
                </div>
              </div>
        </div>
            
    </div>
</body>
</html>
