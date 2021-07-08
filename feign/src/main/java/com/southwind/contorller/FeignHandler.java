package com.southwind.contorller;

import com.southwind.entity.Student;
import com.southwind.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/feign")
public class FeignHandler {
    @Autowired
    private FeignProviderClient feignProviderClient; // 引入创建的声明式接口

    @GetMapping("/findAll")
    public Collection<Student> findAll() {
        return feignProviderClient.findAll();  // 从创建的声明式接口中调用服务提供者的相关接口
    }

    @GetMapping("/index")
    public String index() {
        return feignProviderClient.index();
    }
}
