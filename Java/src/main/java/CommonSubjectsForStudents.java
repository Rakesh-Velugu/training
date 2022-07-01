import java.util.Arrays;
import java.util.Objects;

public class CommonSubjectsForStudents {

    public static void main(String[] args) throws Exception {
        Student student1 = new Student();
        student1.setBatch("c1");
        student1.setName("Rakesh");
        student1.setSubjects(new String[]{"Java", "C"});
        student1.setTimings(new String[]{"10:00-02:00", "3:00-6:00"});

        Student student2 = new Student();
        student2.setBatch("c1");
        student2.setName("Rishi");
        student2.setSubjects(new String[]{"Java", "React"});
        student2.setTimings(new String[]{"10:00-02:00", "3:00-6:00"});

        Student student3 = new Student();
        student3.setBatch("c2");
        student3.setName("Giri");
        student3.setSubjects(new String[]{"C++", "React"});
        student3.setTimings(new String[]{"10:00-02:00", "3:00-6:00"});

        Student student4 = new Student();
        student4.setBatch("c3");
        student4.setName("Dharani");
        student4.setSubjects(new String[]{"Java", "React"});
        student4.setTimings(new String[]{"10:00-02:00", "3:00-6:00"});

        Dog.display();

        Student[] students = new Student[4];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
        students[3] = student4;


        for (int i=0; i< students.length; i++) {
            for (int j=i+1; j< students.length; j++) {StringBuilder stringBuilder = new StringBuilder();
                if (Arrays.equals(students[i].getSubjects(), students[j].getSubjects())) {
                    getCommonStudentsInfo(students, i, j, stringBuilder);
                    stringBuilder.append(Arrays.toString(students[i].getSubjects())).append(" ").append(Arrays.toString(students[i].getTimings()));
                    System.out.println(stringBuilder);
                } else {
                    for (int k = 0; k < students[i].getSubjects().length; k++) {
                        if (Objects.equals(students[i].getSubjects()[k], students[j].getSubjects()[k])) {
                            getCommonStudentsInfo(students, i, j, stringBuilder);
                            stringBuilder.append(students[i].getSubjects()[k]).append(" ").append(students[i].getTimings()[k]);
                            System.out.println(stringBuilder);
                        }
                    }
                }
            }
        }
    }

    private static void getCommonStudentsInfo(Student[] students, int i, int j, StringBuilder stringBuilder) {
        stringBuilder.append(students[i].getName()).append(" ").append(students[j].getName()).append(" ");
        if (students[i].getBatch().equals(students[j].getBatch())) {
            stringBuilder.append(students[j].getBatch()).append(" ");
        } else {
            stringBuilder.append(students[i].getBatch()).append(" ").append(students[j].getBatch()).append(" ");
        }
    }
}
