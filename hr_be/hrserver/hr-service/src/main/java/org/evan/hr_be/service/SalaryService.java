package org.evan.hr_be.service;

import org.evan.hr_be.mapper.SalaryMapper;
import org.evan.hr_be.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Evan Feng
 * @Date 1/10/2023
 * @Github https://github.com/EvanFung
 */
@Service
public class SalaryService {
    @Autowired
    SalaryMapper salaryMapper;
    public List<Salary> getAllSalaries() {
        return salaryMapper.getAllSalaries();
    }

    public Integer addSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public Integer deleteSalaryById(Integer id) {
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalaryById(Salary salary) {
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }

}
