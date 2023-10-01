package org.evan.hr_be;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"org.evan.hr_be"})
@MapperScan(basePackages = "org.evan.hr_be.mapper")
public class HrBeApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrBeApplication.class, args);
    }

}
