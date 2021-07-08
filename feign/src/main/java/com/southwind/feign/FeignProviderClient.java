package com.southwind.feign;

import com.southwind.entity.Student;
import com.southwind.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * 声明式接口，只需要声明接口就可以完成映射，不需要像ribbon那样需要写方法的实现
 */
@FeignClient(value = "provider",fallback = FeignError.class)  // 需要访问的微服务，注册中心必须有；通过fallback映射降级处理的实现
public interface FeignProviderClient {
    @GetMapping("/student/findAll")
    public Collection<Student> findAll();

    @GetMapping("/student/index")
    public String index();
}
