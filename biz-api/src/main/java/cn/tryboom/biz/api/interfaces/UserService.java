package cn.tryboom.biz.api.interfaces;

import cn.tryboom.biz.api.model.User;
import cn.tryboom.biz.api.openfeign.UserServiceFeignClientConfiguration;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户服务接口
 * @author biao
 * @since 0.0.1
 */

@FeignClient(name = "user-service", configuration = UserServiceFeignClientConfiguration.class)
@DubboService
public interface UserService {

    @PostMapping("/save")
    Boolean saveUser(@RequestBody User user);

}
