package com.bridgeLabz.employeePayRoll.service;

import com.bridgeLabz.employeePayRoll.entity.EmployeeData;

import java.util.List;


public interface IPayRollService {
    EmployeeData addEmployee(EmployeeData employeeData);  //Method to add Employee Detail.

    EmployeeData getEmployeeByID(Integer id); //Method to find the Employee Detail by their ID.

    List<EmployeeData> getAll(); //Method to get all data as List Present in database.

    EmployeeData updateData(EmployeeData employeeData); // Method to edit the data present in the database.

    String removeData(Integer id); //Method to delete the Employee data of given Employee ID.
}
