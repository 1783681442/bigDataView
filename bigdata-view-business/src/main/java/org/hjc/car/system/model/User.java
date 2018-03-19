package org.hjc.car.system.model;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import org.hjc.base.commons.mybatis.SuperEntity;

import java.util.Date;

/**
 * 系统用户表
 */
@TableName("user")
public class User extends SuperEntity {

    public static final String OBJECT_KEY = "USER";

    /** 登陆名 */
    @TableField("login_name")
    private String loginName;

    /** 用户名 */
    @TableField("name")
    private String name;

    /** 密码 */
    @TableField("password")
    private String password;

    /** 密码加密盐 */
    @TableField("salt")
    private String salt;

    /** 性别 */
    @TableField("sex")
    private Integer sex;

    /** 年龄 */
    @TableField("age")
    private Integer age;

    /** 手机号 */
    @TableField("phone")
    private String phone;

    /** 用户类别 */
    @TableField("user_type")
    private Integer userType;

    /** 用户状态 */
    @TableField("status")
    private Integer status;

    /** 所属机构 */
    @TableField("organization_id")
    private Integer organizationId;
    /**
     * 自定义填充的创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)// 该注解插入忽略验证，自动填充
    private Date createTime;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
