import java.util.Arrays;

public class Sort {

    public static void main(String args[]) {

        System.out.println("Soring the employees based on age");
        Employee employee1 = new Employee("Rakesh", 22, 50000);
        Employee employee2 = new Employee("Giri", 23, 50000);
        Employee employee3 = new Employee("Dharani", 21, 50000);

        Employee[] employees = new Employee[3];
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;

        Arrays.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " "+employee.getAge()+" "+employee.getSalary());
        }
    }
}
