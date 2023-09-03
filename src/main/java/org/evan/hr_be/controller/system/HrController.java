package org.evan.hr_be.controller.system;
/**
 * @Author Evan Feng
 * @Date 02/9/2023
 * @Github https://github.com/EvanFung
 */

import org.evan.hr_be.model.Hr;
import org.evan.hr_be.service.HrService;
import org.evan.hr_be.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

}