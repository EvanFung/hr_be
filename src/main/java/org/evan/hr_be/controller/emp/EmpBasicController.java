package org.evan.hr_be.controller.emp;

import org.evan.hr_be.model.Employee;
import org.evan.hr_be.model.RespPageBean;
import org.evan.hr_be.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Evan Feng
 * @Date 8/9/2023
 * @Github https://github.com/EvanFung
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size, Employee employee) {
        return employeeService.getEmployeeByPage(page, size, employee);
    }
}
