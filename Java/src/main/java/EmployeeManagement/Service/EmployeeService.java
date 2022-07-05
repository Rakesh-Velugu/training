package EmployeeManagement.Service;

import EmployeeManagement.Domain.Employee;
import EmployeeManagement.Exception.ResponseStatusException;

import java.util.List;

public interface EmployeeService {

    void init(List<Employee> employees);

    void displayAllEmployees(List<Employee> employees) throws ResponseStatusException;

    void searchEmployee(List<Employee> employees) throws ResponseStatusException;

    void deleteEmployee(List<Employee> employees) throws ResponseStatusException;

    void addEmployee(List<Employee> employees) throws ResponseStatusException;

    void updateEmployee(List<Employee> employees) throws ResponseStatusException;
}
