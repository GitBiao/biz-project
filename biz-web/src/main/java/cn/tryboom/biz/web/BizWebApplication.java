package cn.tryboom.biz.web;

import cn.tryboom.biz.api.interfaces.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = UserService.class)
public class BizWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizWebApplication.class, args);
    }

}
