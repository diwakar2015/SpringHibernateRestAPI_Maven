<%@include file="header.jsp"%>

<head>
	<title>Employee List Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>

<center>

<%

Boolean status = (Boolean) request.getAttribute("showeditpage");
if(status!=null)
{
if(status)
{
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h5>Update Employee Information</h5>
<form class="navbar-form navbar-middle" role="update-information"
		name="person" action="${contextPath}/person/update" method="post">
		<div class="form-group">
			<table>


	           <tr>
					<td><br></br> &nbsp;&nbsp;Employee ID&nbsp;&nbsp;<input
						type="text" name="id" value="${person.id}" class="form-control" readonly></td>
				</tr>
				<tr>
					<td><br></br>Name&nbsp;<input type="text" name="name" value="${person.name}"
						class="form-control"></td>
				</tr>
				<tr>
					<td><br></br> &nbsp;&nbsp;Country&nbsp;&nbsp;<input
						type="text" name="country" value="${person.country}" class="form-control"></td>
				</tr>
			

			</table>


			<br></br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="submit" class="btn btn-primary navbar-middle">Update</button>

		</div>


	</form>


<% } }%>


<h3>Employee  List</h3>
<c:if test="${!empty listPersons}">
	<table class="tg">
	<tr>
		<th width="80">Person ID</th>
		<th width="120">Person Name</th>
		<th width="120">Person Country</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listPersons}" var="person">
		<tr>
			<td>${person.id}</td>
			<td>${person.name}</td>
			<td>${person.country}</td>
			<td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>


</center>

<%@include file="footer.jsp"%>