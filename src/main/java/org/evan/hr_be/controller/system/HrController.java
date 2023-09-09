package org.evan.hr_be.controller.system;
/**
 * @Author Evan Feng
 * @Date 02/9/2023
 * @Github https://github.com/EvanFung
 */

import org.evan.hr_be.model.Hr;
import org.evan.hr_be.model.RespBean;
import org.evan.hr_be.model.Role;
import org.evan.hr_be.service.HrService;
import org.evan.hr_be.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("Update successfully!");
        }
        return RespBean.error("Update failed!");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("Update successfully!");
        }
        return RespBean.error("Update failed!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if (hrService.deleteHrById(id) == 1) {
            return RespBean.ok("Delete successfully!");
        }
        return RespBean.error("Delete failed!");
    }

}