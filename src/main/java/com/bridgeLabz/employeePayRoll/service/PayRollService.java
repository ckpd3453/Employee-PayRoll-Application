package com.bridgeLabz.employeePayRoll.service;

import com.bridgeLabz.employeePayRoll.entity.EmployeeData;
import com.bridgeLabz.employeePayRoll.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is to provide the service to the user  and perform CRUD operations with data in given table as entity of employee_pay_roll database.
 */
@Service
public class PayRollService implements IPayRollService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;     //Autowired IEmployeeRepository to Instantiate iEmployeeRepository.

    /**
     * Method to Add the Employee Details to the Given table as Entity.
     *
     * @param employeeData - Getting the data from the controller.
     * @return - Adding Data given by the controller to the table in MySql Database(i,e. employee_pay_roll).
     */
    @Override
    public EmployeeData addEmployee(EmployeeData employeeData) {
        return iEmployeeRepository.save(employeeData);
    }

    /**
     * Method to find the information of the Employee using their ID.
     *
     * @param id - Passed by the controller
     * @return - finds all the details of an Employee using their ID.
     */
    @Override
    public EmployeeData getEmployeeByID(Integer id) {
        return iEmployeeRepository.findById(id).get();
    }

    /**
     * Method to find all the data of Employee Present in the data base as list.
     *
     * @return - get all the Employee Data Present in the database as list.
     */
    @Override
    public List<EmployeeData> getAll() {
        return iEmployeeRepository.findAll();
    }

    /**
     * Method to update/edit the Employee Data.
     *
     * @param employeeData existing one.
     * @return -  updated employee Data
     */
    @Override
    public EmployeeData updateData(EmployeeData employeeData) {
        if (iEmployeeRepository.findById(employeeData.getId()).isPresent())
            return iEmployeeRepository.save(employeeData);
        else
            return new EmployeeData(-1, "Sorry...!!! Employee Not Exists by This ID");
    }

    /**
     * Method to Remove the Employee Data of Given Employee ID.
     *
     * @param id - Passed By Controller.
     * @return - Deletion Successful message.
     */
    @Override
    public String removeData(Integer id) {
        if (iEmployeeRepository.findById(id).isPresent()) {
            iEmployeeRepository.deleteById(id);
            return "Given Employee Data is Deleted Successfully....";
        } else {
            return "Sorry...!!! Employee Not Exists by This ID";
        }
    }
}
