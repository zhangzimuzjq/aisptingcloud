package com.southwind.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/native")
public class NativeConfigHandler {
    @Value("${server.port}")
    private String port;  // 获取配置文件里面的server.port

    @Value("${foo}")
    private String foo;    // 获取配置文件里面的foo

    @GetMapping("/index")
    public String index() {
        return this.port + "-" + this.foo;
    }
}
