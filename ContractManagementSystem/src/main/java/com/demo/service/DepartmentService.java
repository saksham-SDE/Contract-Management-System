package com.demo.service;

import com.demo.DTO.Department;
import com.demo.VO.DepartmentVo;
import com.demo.repository.DepartmentRepo;
import com.demo.utility.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    // Get all Departments (VO)
    public List<DepartmentVo> getAllDepartmentsVo() {
        return departmentRepo.findAll().stream()
                .map(DepartmentMapper::mapToVo)
                .collect(Collectors.toList());
    }

    // Get Department by ID (VO)
    public DepartmentVo getDepartmentVoById(int id) {
        return departmentRepo.findById(id)
                .map(DepartmentMapper::mapToVo)
                .orElse(null);
    }

    // Add Department (VO)
    public DepartmentVo addDepartmentVo(DepartmentVo vo) {
        Department saved = departmentRepo.save(DepartmentMapper.mapToEntity(vo));
        return DepartmentMapper.mapToVo(saved);
    }

    // Update Department (VO)
    public DepartmentVo updateDepartmentVo(int id, DepartmentVo vo) {
        return departmentRepo.findById(id).map(department -> {
            if (vo.getDep_name() != null) department.setDep_name(vo.getDep_name());
            if (vo.getDescription() != null) department.setDescription(vo.getDescription());
            if (vo.getDep_address() != null) department.setDep_address(vo.getDep_address());
            Department updated = departmentRepo.save(department);
            return DepartmentMapper.mapToVo(updated);
        }).orElse(null);
    }

    // Delete Department
    public void deleteDepartmentById(int id) {
        departmentRepo.deleteById(id);
    }

    // Delete multiple Departments
    public void deleteDepartmentsByIds(List<Integer> ids) {
        departmentRepo.deleteAllById(ids);
    }
}
