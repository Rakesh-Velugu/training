package EmployeeManagement.Service.Impl;

import EmployeeManagement.Service.CommonMessagesService;

public class CommonMessagesServiceImpl implements CommonMessagesService {
    @Override
    public String showGreetings() {
        return "Welcome to employee management System";
    }

    @Override
    public String showOptions() {
        return "1.Show all employees" + "\n" +
                "2.Search an employee" + "\n" +
                "3.Delete an Employee" + "\n" +
                "4.Add an employee" + "\n" +
                "5.Update an Employee" + "\n" +
                "-1. Exit" ;
    }

    @Override
    public String showUpdateOptions() {
        return "1.Name" + "\n" +
                "2.Age" + "\n" +
                "3.Salary";
    }

    @Override
    public String showSearchOptions() {
        return "1.Id" + "\n" +
                "2.Name" + "\n" +
                "3.Designation" + "\n" +
                "4.Salary" + "\n";
    }
}
