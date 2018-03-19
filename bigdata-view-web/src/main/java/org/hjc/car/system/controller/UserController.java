package org.hjc.car.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : wangchao
 * @description: (class comments must say something)
 * @modify_list : (modify by :modify date:modify content)
 * @create_time : 2018/3/16 15:50
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/toUserPage")
    public String userPage(){return "/user";}

}
