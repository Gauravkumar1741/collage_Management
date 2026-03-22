package com.college.service;

import com.college.entity.*;
import com.college.util.JPAUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class CollegeService {

    public void addStudent(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Student s = new Student();
        s.setName(name);

        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }

    public void addCourse(String courseName) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Course c = new Course();
        c.setCourseName(courseName);

        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }

    public void addFaculty(String name, String dept) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Faculty f = new Faculty();
        f.setName(name);
        f.setDepartment(dept);

        em.persist(f);
        em.getTransaction().commit();
        em.close();
    }

    // Enroll student to course
    public void enrollStudent(int studentId, int courseId) {

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Student s = em.find(Student.class, studentId);
        Course c = em.find(Course.class, courseId);

        s.getCourses().add(c);
        c.getStudents().add(s);

        em.getTransaction().commit();
        em.close();
    }

    // Assign faculty
    public void assignFaculty(int facultyId, int courseId) {

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Faculty f = em.find(Faculty.class, facultyId);
        Course c = em.find(Course.class, courseId);

        c.setFaculty(f);

        em.getTransaction().commit();
        em.close();
    }

    public void fetchStudentsPerCourse(int courseId) {

        EntityManager em = JPAUtil.getEntityManager();

        Course c = em.find(Course.class, courseId);

        for (Student s : c.getStudents()) {
            System.out.println(s.getName());
        }

        em.close();
    }

    public void fetchCoursesByFaculty(int facultyId) {

        EntityManager em = JPAUtil.getEntityManager();

        List<Course> list =
            em.createQuery(
                "from Course where faculty.facultyId = :id",
                Course.class)
            .setParameter("id", facultyId)
            .getResultList();

        for (Course c : list) {
            System.out.println(c.getCourseName());
        }

        em.close();
    }
}