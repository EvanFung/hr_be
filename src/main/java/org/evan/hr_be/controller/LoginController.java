package org.evan.hr_be.controller;

import org.evan.hr_be.model.RespBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Evan Feng
 * @Date 14/8/2023
 * @Github https://github.com/EvanFung
 */
@RestController
public class LoginController {
    @GetMapping("/login")
//    @CrossOrigin("*")
    public RespBean login() {
        return RespBean.error("Not logged in, please login");
    }
}
