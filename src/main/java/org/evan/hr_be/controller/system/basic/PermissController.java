package org.evan.hr_be.controller.system.basic;

import org.evan.hr_be.model.Menu;
import org.evan.hr_be.model.RespBean;
import org.evan.hr_be.model.Role;
import org.evan.hr_be.service.MenuService;
import org.evan.hr_be.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 27/8/2023
 * @Github https://github.com/EvanFung
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if(menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("Update successfully!");
        }
        return RespBean.ok("Update failed!");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if(roleService.addRole(role) == 1) {
            return RespBean.ok("Add successfully!");
        }
        return RespBean.error("Add failed!");
    }
}
