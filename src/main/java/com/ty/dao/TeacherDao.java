package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.dto.Teacher;

@Component
public class TeacherDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Teacher saveTeacher(Teacher teacher) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();

		return teacher;
	}

	public List<Teacher> getAllTeacher() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String select = "SELECT t FROM Teacher t";

		Query query = entityManager.createQuery(select);

		List<Teacher> list = query.getResultList();

		return list;
	}

	public void deleteById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Teacher teacher = entityManager.find(Teacher.class, id);

		entityTransaction.begin();

		entityManager.remove(teacher);

		entityTransaction.commit();
	}

	public Teacher updateTeacher(Teacher teacher) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Teacher teacher1 = entityManager.find(Teacher.class,teacher.getId());

		if (teacher1 != null) {
			entityTransaction.begin();
			entityManager.merge(teacher);
			entityTransaction.commit();
			return teacher;
		}

		return null;
	}
	
	public Teacher getTeacherById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Teacher.class,id);
	}
}
