package com.zps.springboot_03_datasource.pojo;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String user_name;
    private String password;
    private String name;
    private int age;
    private int sex;
    private Date birthday;
    private String note;
    private Date created;
    private Date updated;
}
