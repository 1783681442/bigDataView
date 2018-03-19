package org.hjc.car.system.service;/**
 * @project_name : ssm-base
 * @author : wangchao
 * @create_time : 2018/1/17 14:16
 * @classname :  org.hjc.ssm.user.service.IUserService
 * @class_comments: (class comments must say something)
 * @modify_list : (modify by :modify date:modify content)
 */


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.hjc.car.system.model.User;
import org.springframework.cache.annotation.Cacheable;

/**
 * org.hjc.car.system.service
 *
 * @author hanjc
 * @create 2018-01-17 14:16
 **/
public interface IUserService extends IService<User> {

    Page<User> selectUserList(Page<User> page);

    User selectUserById(String userId);
}
