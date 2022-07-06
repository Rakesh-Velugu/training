package Student.Domain;


public class Student {
    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    private String studentName;

    public Student(int studentId, String studentName, String studentGrade, String studentClass) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentGrade = studentGrade;
        this.studentClass = studentClass;
    }

    private String studentGrade;
    private String studentClass;
}
