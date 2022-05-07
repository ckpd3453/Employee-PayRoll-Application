package com.bridgeLabz.employeePayRoll.controller;

import com.bridgeLabz.employeePayRoll.entity.EmployeeData;
import com.bridgeLabz.employeePayRoll.service.IPayRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller Class
 * URL - http://localhost:8081/payRoll
 */
@RestController
@RequestMapping("/payRoll")
public class PayRoll {

    @Autowired
    private IPayRollService iPayRollService;        //Autowired IPayrollService to Instantiate iPayRollService.

    /**
     * Method to Add the Employee Details to the Given table as Entity.
     *
     * @param employeeData - Getting the data from the user.
     * @return - Adding Data given by the user to the table in MySql Database(i,e. employee_pay_roll).
     * URL - http://localhost:8081/payRoll/add
     */
    @PostMapping("/add")
    public EmployeeData dataEntry(@RequestBody EmployeeData employeeData) {
        return iPayRollService.addEmployee(employeeData);
    }

    /**
     * Method to get the information of the Employee using their ID.
     *
     * @param id - Passed by the user
     * @return - finds all the details of an Employee using their ID.
     * URL - http://localhost:8081/payRoll/find?id=3
     */
    @GetMapping("/find")
    public EmployeeData getData(@RequestParam(value = "id") Integer id) {
        return iPayRollService.getEmployeeByID(id);
    }


    /**
     * Method to get all Employee data Present in the table in list form.
     *
     * @return - finds all the details of all Employee in the table in list form .
     * URL - http://localhost:8081/payRoll/findAll
     */
    @GetMapping("/findAll")
    public List<EmployeeData> getAll() {
        return iPayRollService.getAll();
    }

    /**
     * Method to update/edit the Employee Data
     *
     * @param employeeData - Passed by the user
     * @return - Updated/Edited Data.
     * URL - http://localhost:8081/payRoll/edit
     */
    @PutMapping("edit")
    public EmployeeData updateData(@RequestBody EmployeeData employeeData) {
        return iPayRollService.updateData(employeeData);
    }

    /**
     * Method to remove the Employee Data of the given Employee ID.
     *
     * @param id - Passed by the user.
     * @return - Deleted Successful Message in String Type.
     * URL - http://localhost:8081/payRoll/del
     */
    @DeleteMapping("/del")
    public String removeData(@RequestParam(value = "id") Integer id) {
        return iPayRollService.removeData(id);
    }
}
