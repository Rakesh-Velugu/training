package Student.Service;

import EmployeeManagement.Exception.ResponseStatusException;
import Student.Domain.Student;

import java.util.List;

public interface StudentService {
    void insertStudent(Student student, List<Student> students) throws ResponseStatusException;
}
