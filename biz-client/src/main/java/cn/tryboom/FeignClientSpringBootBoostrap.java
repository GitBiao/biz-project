package cn.tryboom;

import cn.tryboom.biz.api.interfaces.UserService;
import cn.tryboom.biz.api.model.User;
import cn.tryboom.client.loadbalancer.UserServiceLoadBalancerConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration
@EnableFeignClients(clients = UserService.class)
@LoadBalancerClient(name = "user-service", configuration = UserServiceLoadBalancerConfiguration.class)
public class FeignClientSpringBootBoostrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FeignClientSpringBootBoostrap.class)
                .web(WebApplicationType.NONE)
                .build()
                .run(args);

        UserService userRegistrationService = context.getBean(UserService.class);

        User user = new User();
        user.setId(1L);
        user.setName("ABC");
        System.out.println(userRegistrationService.saveUser(user));

        context.close();
    }

}
