package EmployeeManagement.Service.Impl;

import EmployeeManagement.Domain.Employee;
import EmployeeManagement.Exception.ResponseStatusException;
import EmployeeManagement.Service.CommonMessagesService;
import EmployeeManagement.Service.EmployeeService;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class EmployeeServiceImpl implements EmployeeService {

    Scanner scanner = new Scanner(System.in);

    CommonMessagesService commonMessagesService = new CommonMessagesServiceImpl();

    @Override
    public void init(List<Employee> employees) {
        Employee employee = new Employee(1, "Rakesh", "Software Developer", 500000);
        Employee employee1 = new Employee(2, "Giri", "Software Developer", 50000);

        employees.add(employee);
        employees.add(employee1);
    }

    private void printEmployee(Employee employee) {
        System.out.println("EmployeeId: " + employee.getId());
        System.out.println("EmployeeName: " + employee.getName());
        System.out.println("EmployeeDesignation: " + employee.getDesignation());
        System.out.println("EmployeeSalary: " + employee.getSalary() + "\n");
    }

    @Override
    public void displayAllEmployees(List<Employee> employees) throws ResponseStatusException {
        if (employees.isEmpty()) {
            throw new ResponseStatusException("No Employees found");
        }
        employees.forEach(this::printEmployee);
    }

    @Override
    public void searchEmployee(List<Employee> employees) throws ResponseStatusException {
        AtomicReference<Boolean> employeeFound = new AtomicReference<>();
        employeeFound.set(Boolean.FALSE);
        System.out.println("Please enter the employee filed to search");
        System.out.println(commonMessagesService.showSearchOptions());
        int control = scanner.nextInt();
        if (employees.isEmpty()) {
            throw new ResponseStatusException("No Employees found");
        }
        switch (control) {
            case 1:
                System.out.println("Please enter the employee id to search");
            int id = scanner.nextInt();
                employees.forEach(employee -> {
                    if (id == employee.getId()) {
                        employeeFound.set(Boolean.TRUE);
                       printEmployee(employee);
                    }
                });break;
            case 2:
                System.out.println("Please enter the employee name to search");
                String name = scanner.next();
                employees.forEach(employee -> {
                    if (name.equalsIgnoreCase(employee.getName())) {
                        employeeFound.set(Boolean.TRUE);
                       printEmployee(employee);
                    }
                });break;
            case 3:
                System.out.println("Please enter the employee designation to search");
               String designation = scanner.next();
                employees.forEach(employee -> {
                    if (designation.equalsIgnoreCase(employee.getDesignation())) {
                        employeeFound.set(Boolean.TRUE);
                       printEmployee(employee);
                    }
                });break;
            case 4:
                System.out.println("Please enter the employee salary to search");
                int salary  = scanner.nextInt();
                employees.forEach(employee -> {
                    if (salary == employee.getSalary()) {
                        employeeFound.set(Boolean.TRUE);
                        printEmployee(employee);
                    }
                });break;
            default: throw new ResponseStatusException("Please enter a valid option");
            }
        if (!employeeFound.get()) {
            throw new ResponseStatusException("No Employee found with given id");
        }
    }

    @Override
    public void deleteEmployee(List<Employee> employees) throws ResponseStatusException {
        List<Employee> employeeList = new ArrayList<>(employees);
        AtomicReference<Boolean> isDeleted = new AtomicReference<>();
        isDeleted.set(Boolean.FALSE);
        System.out.println("Please enter the employee Id to delete");
        int id = scanner.nextInt();
        if (employees.isEmpty()) {
            throw new ResponseStatusException("No Employees found");
        } else {
            employeeList.forEach(employee -> {
                if (employee.getId() == id) {
                    isDeleted.set(true);
                    employees.remove(employee);
                }
            });

            if (isDeleted.get()) {
                System.out.println("Employee deleted");
            } else {
                throw new ResponseStatusException("No Employee found with given id");
            }
        }
    }

    @Override
    public void addEmployee(List<Employee> employees) throws ResponseStatusException{
        System.out.println("Please enter the Employee ID");
        int id = scanner.nextInt();
        System.out.println("Please enter the Employee name");
        String name = scanner.next();
        System.out.println("Please enter the Employee age");
        String designation = scanner.next();
        System.out.println("Please enter the Employee Salary");
        double salary  = scanner.nextDouble();
        Employee employee = new Employee(id, name, designation, salary);
       if (employees.stream().anyMatch(employee1 -> employee1.getId() == id)) {
           throw new ResponseStatusException("Employee already exists with given ID");
       } else {
           employees.add(employee);
           System.out.println("Employee added");
       }
    }

    @Override
    public void updateEmployee(List<Employee> employees) throws ResponseStatusException {
        System.out.println("Please enter the Employee id you want to update");
        int id = scanner.nextInt();
        AtomicReference<Boolean> isUpdated = new AtomicReference<>();
        isUpdated.set(Boolean.FALSE);
        System.out.println("Please select field which you want to Update");
        System.out.println(commonMessagesService.showUpdateOptions());
        int control = scanner.nextInt();
        switch (control) {
            case 1: System.out.println("Please Enter Employee name");
                String name = scanner.next();
                    employees.forEach(employee -> {
                        if (employee.getId() == id) {
                            isUpdated.set(true);
                            employee.setName(name);
                        }
                    });
            break;
            case 2 : System.out.println("Please Enter Employee designation");
                String designation  = scanner.next();
                employees.forEach(employee -> {
                    if (employee.getId() == id) {
                        isUpdated.set(true);
                        employee.setDesignation(designation);
                    }
                });
                break;
            case 3 : System.out.println("Please Enter Employee salary");
                double salary = scanner.nextDouble();
                employees.forEach(employee -> {
                    if (employee.getId() == id) {
                        if (salary < employee.getSalary()) {
                            try {
                                throw new ResponseStatusException("Salary cannot be decreased");
                            } catch (ResponseStatusException e) {
                               System.out.println(e.getErrorMessage());
                            }
                        } else {
                            isUpdated.set(true);
                            employee.setSalary(salary);
                        }
                    }
                });
                break;
        }
        if (isUpdated.get()) {
            System.out.println("Employee updated");
        } else {
            throw new ResponseStatusException("Unable to update Employee");
        }
    }
}
