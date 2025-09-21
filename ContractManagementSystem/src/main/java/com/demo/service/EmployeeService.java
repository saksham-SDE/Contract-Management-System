package com.demo.service;

import com.demo.DTO.Employee;
import com.demo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    //Retrieves all employees from the database
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }
    //Retrieve employee by id from the database
    public Employee getEmployeeById(int id){
        return employeeRepo.findById(id).orElse(null);
    }
    //Add new employee to the database
    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    //Delete the employee by id from the database
    public void deleteEmployeeById(int id){
        employeeRepo.deleteById(id);
    }
    //Update employee details by id in database
    public Employee updateEmployeeById(int id, Employee updatedEmployee) {
        return employeeRepo.findById(id)
                .map(employee -> {
                    if (updatedEmployee.getName() != null) {
                        employee.setName(updatedEmployee.getName());
                    }
                    if (updatedEmployee.getDep_id() != 0) {
                        employee.setDep_id(updatedEmployee.getDep_id());
                    }
                    if (updatedEmployee.getE_designation() != null) {
                        employee.setE_designation(updatedEmployee.getE_designation());
                    }
                    if (updatedEmployee.getE_email_id() != null) {
                        employee.setE_email_id(updatedEmployee.getE_email_id());
                    }
                    if (updatedEmployee.getE_contact_no() != null) {
                        employee.setE_contact_no(updatedEmployee.getE_contact_no());
                    }
                    return employeeRepo.save(employee);
                }).orElse(null);
    }
    public void deleteEmployeesByIDs(List<Integer> employeeIDs){
        employeeRepo.deleteAllById(employeeIDs);
    }


}
