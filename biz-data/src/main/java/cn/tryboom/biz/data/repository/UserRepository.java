package cn.tryboom.biz.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data Commons 会帮助接口生成代理对象 实现Repository 透明化 （SQL、NoSQL）
 * @author biao
 * @see CrudRepository
 * @since
 */
@Repository
public interface UserRepository extends CrudRepository {

}
