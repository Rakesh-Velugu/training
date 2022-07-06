package Student;

import EmployeeManagement.Exception.ResponseStatusException;
import Student.Domain.Student;
import Student.Service.Impl.StudentServiceImpl;
import Student.Service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRunner {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        StudentService studentService = new StudentServiceImpl();
        
        Scanner scanner = new Scanner(System.in);

        char c = 'Y';
        do {
        System.out.println("Please enter Student Id");
        int id = scanner.nextInt();
        System.out.println("Please enter Student Name");
        String name = scanner.next();
        System.out.println("Please enter Student Grade");
        String grade = scanner.next();
        System.out.println("Please enter Student class");
        String studentClass = scanner.next();

        Student student = new Student(id, name, grade, studentClass);

        try {
            studentService.insertStudent(student, students);
        } catch (ResponseStatusException e) {
            System.out.println(e.getErrorMessage());
        }

        System.out.println("Do you want to continue Y/N");
        c = scanner.next().charAt(0);
        } while(c != 'N');
    }
}
