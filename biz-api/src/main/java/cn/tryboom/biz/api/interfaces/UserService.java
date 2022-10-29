package cn.tryboom.biz.api.interfaces;

import cn.tryboom.biz.api.model.User;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户服务接口
 * @author biao
 * @since 0.0.1
 */

@FeignClient("${user-service.name}")
@RequestMapping("/user")
@DubboService
public interface UserService {

    @PostMapping("/save")
    Boolean saveUser(User user);

}
