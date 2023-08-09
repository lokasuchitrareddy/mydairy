 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1 ,">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <link rel="stylesheet" type="text/css" href='<c:url value="/resources/styles/style2.css"/>'>
</head>
<body>
	<div class="container-fluid">
		<div class="row text-center">
			<div class="page-header">
				<h1>MY DAIRY</h1>
			</div>
		</div>
		<div class="row main-content">
			<div class="col-xs-3">
			</div>
			<div class="col-xs-6">
				<div class="row text-center">
					<h2>REGISTRATION FORM</h2>
				</div>
				<form action="./userRegister">
  					<div class="input-group">
    					<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
    					<input type="text" id="username" name="username" class="form-control" placeholder="Username" required>
  					</div>
  					<div class="input-group">
    					<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
    					<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
  					</div>
  					<div class="input-group">
    					<button  type="submit" class="form-control">  Register  </button>
 	 				</div>
				</form>
			</div>
			<div class="col-xs-3"></div>
		</div>
		<div class="row text-center">
		<h4>Existing User? <a href="./home">Login</a> here</h4>
		</div>
	</div>
</body>
</html>