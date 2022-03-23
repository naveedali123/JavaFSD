package com.learnersacademy.database;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.learnersacademy.models.Student;
import com.learnersacademy.models.Subject;
import com.learnersacademy.models.Teacher;
import com.learnersacademy.models.Class;

public class DbRetrieve {

	private DataSource dataSource;

	public DbRetrieve(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Student> getStudents() {

		List<Student> students = new ArrayList<>();

		String dbUrl = "jdbc:mysql://localhost:3306/learner_academy";
		String userName = "root";
		String pwd = "Simplilearn";

		try {

             DBConnection dConnection = new DBConnection(dbUrl, userName, pwd);
			
			 Statement stmt = dConnection.getConnection().createStatement();

			 ResultSet rs = stmt.executeQuery("select * from students");
			
			 while (rs.next()) {

				int id = rs.getInt("id");
				String firstName = rs.getString("fname");
				String lastName = rs.getString("lname");
				int age = rs.getInt("age");
				int aclass = rs.getInt("class");

				Student tempStudent = new Student(id, firstName, lastName, age, aclass);
				students.add(tempStudent);
			}
			 stmt.close();
				dConnection.closeConnection();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return students;

	}

	public List<Teacher> getTeachers() {

		List<Teacher> teachers = new ArrayList<>();

		String dbUrl = "jdbc:mysql://localhost:3306/learner_academy";
		String userName = "root";
		String pwd = "Simplilearn";

		try {

             DBConnection dConnection = new DBConnection(dbUrl, userName, pwd);
			
			Statement stmt = dConnection.getConnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from teachers");
			
			while (rs.next()) {

				int id = rs.getInt("id");
				String firstName = rs.getString("tfname");
				String lastName = rs.getString("lname");
				int age = rs.getInt("age");

				Teacher temp = new Teacher(id, firstName, lastName, age);

				teachers.add(temp);
		}
			stmt.close();
			dConnection.closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return teachers;

	}

	public List<Subject> getSubjects() {

		List<Subject> subjects = new ArrayList<>();

		String dbUrl = "jdbc:mysql://localhost:3306/learner_academy";
		String userName = "root";
		String pwd = "Simplilearn";

		try {

             DBConnection dConnection = new DBConnection(dbUrl, userName, pwd);
			
			 Statement stmt = dConnection.getConnection().createStatement();

			 ResultSet rs = stmt.executeQuery("select * from subjects");
			
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String shortcut = rs.getString("shortcut");
				Subject temp = new Subject(id, name,shortcut);

				subjects.add(temp);
				
			}
			stmt.close();
			dConnection.closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return subjects;

	}

	public List<Class> getClasses() {

		List<Class> classes = new ArrayList<>();

		String dbUrl = "jdbc:mysql://localhost:3306/learner_academy";
		String userName = "root";
		String pwd = "Simplilearn";

		try {

             DBConnection dConnection = new DBConnection(dbUrl, userName, pwd);
			
			 Statement stmt = dConnection.getConnection().createStatement();

			 ResultSet rs = stmt.executeQuery("select * from classes");
			
			while (rs.next()) {

				int id = rs.getInt("id");
				
				String name = rs.getString("name");
				
				Class temp = new Class(id, name);
				classes.add(temp);
				
			}
			stmt.close();
			dConnection.closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return classes;

	}

	public Teacher loadTeacher(int teacherId) {

		Teacher theTeacher = null;

		String dbUrl = "jdbc:mysql://localhost:3306/learner_academy";
		String userName = "root";
		String pwd = "Simplilearn";

		try {

             DBConnection dConnection = new DBConnection(dbUrl, userName, pwd);
			
			 Statement stmt = dConnection.getConnection().createStatement();

			 ResultSet rs = stmt.executeQuery("SELECT * FROM teachers WHERE id = " + teacherId);
			
			 while (rs.next()) {

				int id = rs.getInt("id");
				String fname = rs.getString("tfname");
				String lname = rs.getString("lname");
				int age = rs.getInt("age");
				theTeacher = new Teacher(id, fname, lname, age);
				
			}
			 stmt.close();
			dConnection.closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return theTeacher;

	}

	public Subject loadSubject(int subjectId) {

		Subject theSubject = null;

		String dbUrl = "jdbc:mysql://localhost:3306/learner_academy";
		String userName = "root";
		String pwd = "Simplilearn";

		try {

             DBConnection dConnection = new DBConnection(dbUrl, userName, pwd);
			
			 Statement stmt = dConnection.getConnection().createStatement();

			 ResultSet rs = stmt.executeQuery("SELECT * FROM subjects WHERE id = " + subjectId);

			 while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String shortcut = rs.getString("shortcut");

				theSubject = new Subject(id, name,shortcut);
				
			}
			 stmt.close();
			 dConnection.closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		return theSubject;

	}

	public Class loadClass(int classId) {

		Class theClass = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/learner_academy";
		String userName = "root";
		String pwd = "Simplilearn";
		try {

             DBConnection dConnection = new DBConnection(dbUrl, userName, pwd);
			
			 Statement stmt = dConnection.getConnection().createStatement();

			 ResultSet rs = stmt.executeQuery("SELECT * FROM clasess WHERE id = " + classId);
			
			 while (rs.next()) {
				int id = rs.getInt("id");
				int section = rs.getInt("section");
				int subject = rs.getInt("subject");
				int teacher = rs.getInt("teacher");
				String time = rs.getString("time");

				Teacher tempTeacher = loadTeacher(teacher);
				Subject tempSubject = loadSubject(subject);

				String teacher_name = tempTeacher.getFname() + " " + tempTeacher.getLname();
				
			}
			 stmt.close();
			dConnection.closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return theClass;

	}

	public List<Student> loadClassStudents(int classId) {

		List<Student> students = new ArrayList<>();

		String dbUrl = "jdbc:mysql://localhost:3306/learner_academy";
		String userName = "root";
		String pwd = "Simplilearn";
		try {

            DBConnection dConnection = new DBConnection(dbUrl, userName, pwd);
			
			 Statement stmt = dConnection.getConnection().createStatement();

			 ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE class = " + classId);
			
			 while (rs.next()) {

				int id = rs.getInt("id");
				String firstName = rs.getString("fname");
				String lastName = rs.getString("lname");
				int age = rs.getInt("age");
				int aclass = rs.getInt("class");

				Student tempStudent = new Student(id, firstName, lastName, age, aclass);
				students.add(tempStudent);
				
			}
			 stmt.close();
				dConnection.closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return students;

	}

}

