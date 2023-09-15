package org.evan.hr_be.service;

import org.evan.hr_be.mapper.EmployeeMapper;
import org.evan.hr_be.model.Employee;
import org.evan.hr_be.model.RespPageBean;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public final static Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee, beginDateScope);
        Long total = employeeMapper.getTotal(employee, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data)  ;
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        int result = employeeMapper.insertSelective(employee);
        return result;
    }

    public Integer deleteEmpByEid(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }


    public Integer updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

    public Integer addEmps(List<Employee> list) {
        return employeeMapper.addEmps(list);
    }
}
