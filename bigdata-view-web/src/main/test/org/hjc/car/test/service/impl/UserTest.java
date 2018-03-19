package org.hjc.car.test.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.hjc.car.system.model.User;
import org.hjc.car.system.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author : wangchao
 * @description: (class comments must say something)
 * @modify_list : (modify by :modify date:modify content)
 * @create_time : 2018/3/16 14:17
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring/spring-config.xml"}) //加载配置文件
public class UserTest extends AbstractJUnit4SpringContextTests{

    @Autowired
    private IUserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    @Transactional
    @Rollback(value = true)
    public void insertTest(){
        User user = new User();
        user.setLoginName("zhangsan");
        user.setPassword("1111");
        user.setSex(1);
        user.setUserType(1);
        user.setStatus(1);
        user.setOrganizationId(1);
        user.setAge(18);
        user.setName("张三");
        boolean flag = userService.insert(user);
        throw new RuntimeException("111");
    }

    @Test
    public void testSelect(){
        /*List<User> users = this.userService.selectList(new EntityWrapper<User>());*/
        Page<User> page = new Page<>(1,5);
        Page<User> users = this.userService.selectUserList(page);
        for (User user:users.getRecords()){
            System.out.println(user);
        }
    }

    /**
     *   redisTemplate.opsForValue();//操作字符串
         redisTemplate.opsForHash();//操作hash
         redisTemplate.opsForList();//操作list
         redisTemplate.opsForSet();//操作set
         redisTemplate.opsForZSet();//操作有序set
     */
    @Test
    public void testRedis(){
        //redisTemplate.opsForValue().set("name","张三");
        User user = userService.selectOne(new EntityWrapper<User>().eq("name","张三"));
        //保存对象信息
        redisTemplate.opsForHash().put(User.OBJECT_KEY,user.getId(),user);
        User rdUser = (User) redisTemplate.opsForHash().get(User.OBJECT_KEY,user.getId());
        System.out.println(rdUser.getName());
    }

    @Test
    public void testCache(){
        User user = this.userService.selectUserById("1");
        System.out.println(user.getName());
        User user1 = this.userService.selectUserById("1");
        System.out.println(user1.getName());
    }
}
