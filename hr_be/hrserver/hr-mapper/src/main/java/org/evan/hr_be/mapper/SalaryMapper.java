package org.evan.hr_be.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.evan.hr_be.model.Salary;

import java.util.List;

@Mapper
public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> getAllSalaries();
}