package com.hd.supermarket.model;

import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.util.Date;

/**
 * 管理员账户
 * @author 
 */
@Getter
@Setter
public class AdminAccount {

    /**
     * 账户标识
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 管理员名称
     */
    private String adminName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 默认管理员(0:是,1:否)
     */
    private Integer isDefault;

    /**
     * 是否删除()
     */
    private Integer isDeleted;

}