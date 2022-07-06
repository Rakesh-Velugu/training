package Student.Service.Impl;

import EmployeeManagement.Exception.ResponseStatusException;
import Student.Domain.Student;
import Student.Service.StudentService;

import java.util.Iterator;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public void insertStudent(Student student, List<Student> students) throws ResponseStatusException {
        Iterator<Student> iterator = students.iterator();
        boolean[] isStudentExist = new boolean[]{false};

        while(iterator.hasNext()) {
            Student oldStudent = iterator.next();
            if (oldStudent.getStudentId() == student.getStudentId()) {
                isStudentExist[0] = true;
                break;
            }
        }

        if (isStudentExist[0]) {
            throw new ResponseStatusException("Student already exist with given Id");
        } else {
            students.add(student);
        }
    }
}
