package com.demo.service;

import com.demo.DTO.Department;
import com.demo.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;
    //Retrieve all departments from the database
    public List<Department> getAllDepartment(){
        return departmentRepo.findAll();
    }
    //Retrieve department by id from the database
    public Department getDepartmentById(int id){

        return departmentRepo.findById(id).orElse(null);
    }
    //Add new department to the database
    public Department addDepartment(Department department){
        return departmentRepo.save(department);
    }
    //Delete the department by id from the database
    public void deleteDepartmentById(int id){
        departmentRepo.deleteById(id);
    }
    //Update department details by id in database
    public Department updateDepartmentById(int id , Department updatedDepartment){
        return departmentRepo.findById(id)
                .map(department -> {
                    if(updatedDepartment.getDep_name()!=null){
                    department.setDep_name(updatedDepartment.getDep_name());
                    }
                    if(updatedDepartment.getDep_address()!=null) {
                        department.setDep_address(updatedDepartment.getDep_address());
                    }
                    if(updatedDepartment.getDescription()!=null){
                        department.setDescription(updatedDepartment.getDescription());
                    }
                    return departmentRepo.save(department);
                }).orElse(null);
    }
    public void deleteDepartmentByIDs(List<Integer> departmentIDs){
        departmentRepo.deleteAllById(departmentIDs);
    }
}
