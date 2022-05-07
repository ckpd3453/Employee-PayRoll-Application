package com.bridgeLabz.employeePayRoll.repository;

import com.bridgeLabz.employeePayRoll.entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface extending the interface JpaRepository to perform CRUD operations that are fired from the PayRollService class to the MySql Database,
 * by using one of the ORM Tool that is Hibernate.
 */
@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeData, Integer> {
}
