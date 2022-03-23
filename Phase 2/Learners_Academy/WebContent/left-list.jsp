<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="sidenav">
	<h1 id="logo">
	 Learners Academy
	</h1>
	<c:url var="classesLink" value="AdminControllerServlet">
		<c:param name="command" value="CLASSES" />
	</c:url>

	<c:url var="subjectsLink" value="AdminControllerServlet">
		<c:param name="command" value="SUBJECTS" />
	</c:url>

	<c:url var="teachersLink" value="AdminControllerServlet">
		<c:param name="command" value="TEACHERS" />
	</c:url>

	<c:url var="studentsLink" value="AdminControllerServlet">
		<c:param name="command" value="STUDENTS" />
	</c:url>
	
	<a class="bar-item" href="${classesLink}">Classes</a> 
		<a class="bar-item" href="${subjectsLink}">Subjects</a>
		<a class="bar-item" href="${teachersLink}">Teachers</a> 
		<a class="bar-item" href="${studentsLink}">Students</a> 
		<a class="bar-item" href="masterclass.html">Master Report</a>
		<a class="bar-item" href="Assign-class.html">Assign class</a>
		<a class="bar-item" href="Assign-sub.html">Assign Subject</a>
		<a class="bar-item" href="Assign-teach.html">Assign Teacher</a>
		<a class="bar-item" href="login.jsp">Log out</a>
		

</div>

