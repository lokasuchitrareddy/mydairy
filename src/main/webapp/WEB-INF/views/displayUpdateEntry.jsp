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
			<div class="col-xs-3 text-center">
				<h2 align="center">Welcome <span style="color:steelblue">${username}</span></h2>
				<h4><a href="./home" style="color:blue">Signout</a></h4>
			</div>
			<div class="col-xs-6">
				<div class="row">
					<div class="row text-center">
						<h3>UPDATE ENTRY</h3>
					</div>
			
					<form action="./processUpdated">  
    					<input type="hidden" name="userId" value="${user.id}">
  						<div class="input-group">
    						<label for="Date">Date</label>
                			<input type="text" id="entryDate" name="entrydate" value="${entry.entrydate}">
  						</div>
  						<div class="input-group">
  					 		<label for="comment">Update your activity</label>
							<textarea class="form-control" rows="5" name="description">${entry.description}</textarea>
  						</div>
  						<input type="hidden" name="userId" value="${user.id}">
                 		<input type="hidden" name="id" value="${entry.id}">
  						<div class="input-group">
    						<button  type="submit" class="form-control">UPDATE</button>
 	 					</div>
					</form>
				</div>
			</div>
			<div class="col-xs-3"></div>
		</div>
		<div class="row text-center">
			<p> Not Interested? <a href="./userEntryHome">Back To Home</a></p>
		</div>
	</div>
</body>
</html>