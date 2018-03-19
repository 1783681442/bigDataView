package org.hjc.car.system.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.hjc.car.system.mapper.UserMapper;
import org.hjc.car.system.model.User;
import org.hjc.car.system.service.IUserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    public Page<User> selectUserList(Page<User> page) {
        return page.setRecords(this.baseMapper.selectUserList(page));
    }

    @Override
    @Cacheable(value = "userCache",key = "#userId")
    public User selectUserById(String userId) {
        return this.baseMapper.selectById(userId);
    }
}