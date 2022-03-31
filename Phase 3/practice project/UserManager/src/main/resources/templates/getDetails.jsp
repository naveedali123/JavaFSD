
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>User Manager</title>
</head>
<style> table,td,th {border:1px solid blue; padding:10px;}</style>
<body>
		<div align="center">
		
			<h1>USER DETAILS</h1>
			<table>
				<tr>
					<th>User Name</th>
					<th>User Email</th>
					<th>User Password</th>
				</tr>
				<tr th:value="${userDetails}">
					<td> <span th:text = "${userDetails.username}"></span> </td>
					<td> <span th:text = "${userDetails.useremail}"></span> </td>
					<td> <span th:text = "${userDetails.userpassword}"></span> </td>
				</tr>
			</table>
						
			<h1>Edit Below</h1>
			
			<form action="updateUser" method="post">
					<table border="1" cellpadding="10">
						<tr>
							<th>User ID</th>
							<td><input name="id" type="text" id="id" th:value="${userDetails.userid}" ></td>
						</tr>
						<tr>
							<th>User Name</th>
							<td><input name="name" type="text" id="name" th:value="${userDetails.username}"></td>
						</tr>
						<tr>
							<th>User Email</th>
							<td><input name="email" type="email" id="email"  th:value="${userDetails.useremail}"></td>
						</tr>
						<tr>
							<th>User Password</th>
							<td><input name="password" type="text" id="password" th:value="${userDetails.userpassword}"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<input name="Submit" type="submit" value="Submit" /></td>
						</tr>
					</table>
			</form>
		</div>	
</body>
</html>