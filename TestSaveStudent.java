package com.jsp.student.course;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudent {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jay");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Student> Students = new ArrayList<Student>();
		
		Student s1 = new Student();
		s1.setName("jay");
		s1.setEmail("jay@gmail.com");
		
		Student s2 = new Student();
		s2.setName("Ash");
		s2.setEmail("Ash@gmail.com");
		
		Student s3 = new Student();
		s3.setName("Akka");
		s3.setEmail("akka@gmail.com");
		
		Course c1 = new Course();
		c1.setSubject_name("JAVA");
		c1.setCourse_duration("6 months");
		
		Course c2 = new Course();
		c2.setSubject_name("SQL");
		c2.setCourse_duration("4 months");
		
		Course c3 = new Course();
		c3.setSubject_name("WebTech");
		c3.setCourse_duration("3 months");
		
		
		
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		
		Students.add(s1);
		Students.add(s2);
		Students.add(s3);
		
		s1.setCourse(courses);
		
		c1.setStudents(Students);
		
		Students.clear();
		courses.clear();
		
		Students.add(s2);
		Students.add(s3);
		courses.add(c3);
		courses.add(c2);
		
		s2.setCourse(courses);
		c3.setStudents(Students);
		
		entityTransaction.begin();
		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);
		
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);
		entityTransaction.commit();
		
		System.out.println("All Done");

	}

}
