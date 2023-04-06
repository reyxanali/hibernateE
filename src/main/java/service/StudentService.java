package service;

import dao.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class StudentService {
    public List<Student> getAllStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Student> students = session.createQuery("from Student", Student.class).list();
            transaction.commit();
            return students;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void updateStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
           Student student1 =  session.get(Student.class, 1L);
        System.out.println(student1.getFirstName()+" "+student1.getLastName());
      //  session.save(student);
        // session.delete(student);
        transaction.commit();
        session.clear();
        session.close();
    }

    public Student getStudentById(Long studentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = " FROM Student S WHERE S.id = :studentId";
            Query query = session.createQuery(hql);
            query.setParameter("studentId", studentId);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                return (Student) results.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
        return null;
    }

}

