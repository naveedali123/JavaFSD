<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Classes</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('css/classroom.jpg')">
	<div id="page">
		<jsp:include page="left-list.jsp" />


		<div id="wrapper" >

			<div id="header">
				<h3 >Classes</h3>
			</div>
		</div>


		<div id="container">

			<div id="content">
				
				
				 <form action="masterlist" method="POST">  
        <div class="container"> 
          
        	
			
			Class name:
			<select name="Class" id="Class">
							<option value="1">ML</option>
							<option value="2">JAVA</option>

						</select>	<br/><br/>	
            <input type="submit">
    
        </div>   
    </form>  
				
				<%-- <table>

					<tr>

						<th>ID</th>					
						<th>Name</th>
						<th>Master list</th>
						
					</tr>
					<tr>
					<td>1</td>
					<td>ML</td>
					<td><a href="masterlistservlet">List</a></td>
					</tr>
					
					<tr>
					<td>2</td>
					<td>JAVA</td>
					<td><a href="masterlistservlet">List</a></td>
					</tr>

					<c:forEach var="tempClass" items="${CLASSES_LIST }">
						<tr>

							<c:url var="tempLink" value="AdminControllerServlet">
								<c:param name="command" value="ST_LIST" />
								<c:param name="classId" value="${tempClass.id }" />
								<c:param name="name" value="${tempClass.name }" />
								
							</c:url>

							<td>${tempClass.id}</td>
							<td>${tempClass.name}</td>
							
							 
						</tr>

					</c:forEach>
					<!-- <tr>
					<td>1</td>
					<td>2</td>
					</tr> -->
					
					
					

				</table> --%>
			</div>
		</div>
	</div>

</body>
</html>