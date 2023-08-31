package org.evan.hr_be.service;

import org.evan.hr_be.mapper.DepartmentMapper;
import org.evan.hr_be.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 30/8/2023
 * @Github https://github.com/EvanFung
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }
}
