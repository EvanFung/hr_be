package org.evan.hr_be.controller.salary;

import org.evan.hr_be.model.RespBean;
import org.evan.hr_be.model.Salary;
import org.evan.hr_be.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 1/10/2023
 * @Github https://github.com/EvanFung
 */
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    SalaryService salaryService;
    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary) {
        if (salaryService.addSalary(salary) == 1) {
            return RespBean.ok("Add successfully!");
        }
        return RespBean.error("Add failed!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSalaryById(@PathVariable Integer id) {
        if (salaryService.deleteSalaryById(id) == 1) {
            return RespBean.ok("delete successfully！");
        }
        return RespBean.error("delete failed！");
    }

    @PutMapping("/")
    public RespBean updateSalaryById(@RequestBody Salary salary) {
        if (salaryService.updateSalaryById(salary) == 1) {
            return RespBean.ok("update successfully!");
        }
        return RespBean.error("update fail!");
    }
}
