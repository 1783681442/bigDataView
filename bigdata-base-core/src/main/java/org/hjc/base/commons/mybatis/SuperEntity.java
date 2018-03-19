package org.hjc.base.commons.mybatis;

import java.io.Serializable;

/**
 * <p>
 * 测试自定义实体父类 ， 这里可以放一些公共字段信息
 * </p>
 */
public class SuperEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
