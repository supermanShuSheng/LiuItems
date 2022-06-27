package com.shusheng.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author 刘闯
 * @date 2021/8/12.
 */
@Data
@Table(name = "user")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 334904038966255193L;

    @Column(name = "id")
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private String age;

    /**
     * 不与数据库任何字段对应
     */
    @Transient
    private String love;
}
