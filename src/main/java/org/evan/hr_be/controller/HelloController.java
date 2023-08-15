package org.evan.hr_be.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Evan Feng
 * @Date 13/8/2023
 * @Github https://github.com/EvanFung
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello;";
    }
}
