package com.bridgeLabz.employeePayRoll.entity;
/**
 * Use to simplify the code and reduce the boiler plate code for getter-setter method etc.
 */

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * EmployeeData class is Defining the attributes of the Employee  and getting and setting the values/parameters in them.
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table
public class EmployeeData {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    private String firstName;
    private String lastName;
    private String department;
    private long salary;
}
