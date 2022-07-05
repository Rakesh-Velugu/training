package EmployeeManagement.Service.Impl;

import EmployeeManagement.Service.CommonMessagesService;

public class CommonMessagesServiceImpl implements CommonMessagesService {
    @Override
    public String shoGreetings() {
        return "Welcome to employee management System";
    }

    @Override
    public String shoOption() {
        return "1.Show all employees" + "\n" +
                "2.Search an employee" + "\n" +
                "3.Delete an Employee" + "\n" +
                "4.Add an employee" + "\n" +
                "5.Update an Employee" + "\n" +
                "-1. Exit" ;
    }

    @Override
    public String shopUpdateOptions() {
        return "1.Name" + "\n" +
                "2.Age" + "\n" +
                "3.Salary";
    }

    @Override
    public String shopSearchOptions() {
        return "1.Id" + "\n" +
                "2.Name" + "\n" +
                "3.Designation" + "\n" +
                "4.Salary" + "\n";
    }
}
