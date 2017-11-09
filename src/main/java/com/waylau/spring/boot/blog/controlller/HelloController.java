package com.waylau.spring.boot.blog.controlller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello 控制器.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年4月19日
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world!";
    }




}
