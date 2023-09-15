package org.evan.hr_be.controller.config;

import org.evan.hr_be.model.Menu;
import org.evan.hr_be.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Evan Feng
 * @Date 17/8/2023
 * @Github https://github.com/EvanFung
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;
    @GetMapping("/menu")
    public List<Menu> getMenusByHrId() {
        //can't use parameters which passed from front end
        return menuService.getMenusByHrId() ;
    }
}
