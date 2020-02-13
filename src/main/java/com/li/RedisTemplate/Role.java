package com.li.RedisTemplate;

import java.io.Serializable;

/**
 * @program: RedisLearn
 * @description
 * @author: li
 * @create: 2020-02-12 19:03
 **/
public class Role implements Serializable {

    private static final long serialVersionUID = 2740131122051910764L;
    private Long id;
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
