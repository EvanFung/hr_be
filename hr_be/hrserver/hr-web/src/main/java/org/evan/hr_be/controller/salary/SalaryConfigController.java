package org.evan.hr_be.controller.salary;

import org.evan.hr_be.model.RespBean;
import org.evan.hr_be.model.RespPageBean;
import org.evan.hr_be.model.Salary;
import org.evan.hr_be.service.EmployeeService;
import org.evan.hr_be.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 2/10/2023
 * @Github https://github.com/EvanFung
 */

@RestController
@RequestMapping("/salary/sobcfg")
public class SalaryConfigController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return employeeService.getEmployeeByPageWithSalary(page, size);
    }

    @GetMapping("/salaries")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @PutMapping("/")
    public RespBean updateEmployeeSalaryById(Integer eid, Integer sid) {
        Integer result = employeeService.updateEmployeeSalaryById(eid, sid);
        if (result == 1 || result == 2) {
            return RespBean.ok("Update Successfully!");
        }
        return RespBean.error("Update failed!");
    }
}
