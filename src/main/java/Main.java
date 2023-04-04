import dao.entity.Student;
import service.StudentService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        List<Student> students = studentService.getAllStudents();
      //  students.forEach(student -> System.out.println(student.getFirstName() + " " + student.getLastName()));
    }
}
