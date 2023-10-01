package org.evan.hr_be.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.evan.hr_be.model.Employee;

import java.util.Date;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployeeByPage(@Param("page") Integer page,@Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

    Integer maxWorkID();

    Integer addEmps(@Param("list") List<Employee> list);

    Employee getEmployeeById(Integer id);
}