package org.hjc.car.system.mapper;


import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.hjc.base.commons.mybatis.SuperMapper;
import org.hjc.car.system.model.User;


import java.util.List;

/**
 *
 * User 表数据库控制层接口
 *
 */
public interface UserMapper extends SuperMapper<User> {

    List<User> selectUserList(Pagination page);
}
