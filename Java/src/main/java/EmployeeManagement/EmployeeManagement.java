package EmployeeManagement;

import EmployeeManagement.Domain.Employee;
import EmployeeManagement.Exception.ResponseStatusException;
import EmployeeManagement.Service.CommonMessagesService;
import EmployeeManagement.Service.EmployeeService;
import EmployeeManagement.Service.Impl.CommonMessagesServiceImpl;
import EmployeeManagement.Service.Impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {

    public static void main(String args[]) {

        EmployeeService employeeService = new EmployeeServiceImpl();
        CommonMessagesService commonMessagesService = new CommonMessagesServiceImpl();

        List<Employee>  employees = new ArrayList<>();
        // intializing the employees
        employeeService.init(employees);

        int control = 0; int id;
        Scanner scanner = new Scanner(System.in);
        System.out.println(commonMessagesService.shoGreetings());

        do {
            System.out.println(commonMessagesService.shoOption());
            control = scanner.nextInt();
            switch (control) {
                case 1 :
                    try {
                        employeeService.displayAllEmployees(employees);
                    } catch (ResponseStatusException responseStatusException) {
                        System.out.println(responseStatusException.getErrorMessage());
                    }
                break;
                case 2 :
                    try {
                        employeeService.searchEmployee(employees);
                    } catch (ResponseStatusException responseStatusException) {
                        System.out.println(responseStatusException.getErrorMessage());
                    }
                break;
                case 3 :
                    try {
                        employeeService.deleteEmployee(employees);
                    } catch (ResponseStatusException responseStatusException) {
                        System.out.println(responseStatusException.getErrorMessage());
                    }
                break;
                case 4:
                    try {
                        employeeService.addEmployee(employees);
                    } catch (ResponseStatusException responseStatusException) {
                        System.out.println(responseStatusException.getErrorMessage());
                    }
                break;
                case 5 :
                    try {
                        employeeService.updateEmployee(employees);
                    } catch (ResponseStatusException responseStatusException) {
                        System.out.println(responseStatusException.getErrorMessage());
                    }
                    break;
                case -1:
                break;
                default:
                    System.out.println("Please enter the valid option to proceed");
                    break;
            }
        } while (control != -1);


    }
}
