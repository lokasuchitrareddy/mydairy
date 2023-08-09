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
				<div class="row text-center">
					<h4><a href="./addEntry?username=${username}">Add Entry</a></h4>
				</div>
				<div class="row text-center">
					<table class="table" >
       					<tr>
       						<th>Date</th>
       						<th colspan="3">Actions</th>
       					</tr>
       					<c:if test="${entries.size()==0}">
       						<tr>
       							<td colspan="2">
    							<h4 align="center" style="color:green">You don't have any records</h4>
       							</td>
       						</tr>
       					</c:if>
       					<c:forEach items="${entries}" var="entry">
       						<tr>
       							<td>${entry.entrydate}</td>	
       							<td><a href="./viewEntry?id=${entry.id}">View</a></td>
       							<td><a href="./updateEntry?id=${entry.id}">Update</a></td>
       							<td><a href="./deleteEntry?id=${entry.id}">Delete</a></td>
       						</tr>
       					</c:forEach>
       				</table>
       			</div>	
			</div>
			<div class="col-xs-3"></div>
		</div>
	</div>
</body>
</html>