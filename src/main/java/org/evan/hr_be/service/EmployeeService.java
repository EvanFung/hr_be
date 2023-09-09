package org.evan.hr_be.service;

import org.evan.hr_be.mapper.EmployeeMapper;
import org.evan.hr_be.model.Employee;
import org.evan.hr_be.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 8/9/2023
 * @Github https://github.com/EvanFung
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee) {
        if(page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee);
        Long total = employeeMapper.getTotal(employee);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(total);
        return respPageBean;
    }
}
