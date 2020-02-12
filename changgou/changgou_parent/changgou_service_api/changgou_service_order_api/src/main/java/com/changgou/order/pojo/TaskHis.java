package com.changgou.order.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by zps on 2020/2/6 17:13
 */
@Table(name = "tb_task_his")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskHis {

    @Id
    private Long id;


    // @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;


    //@ColumnType(jdbcType = JdbcType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;

    //@ColumnType(jdbcType = JdbcType.TIMESTAMP)
    @Column(name = "delete_time")
    private Date deleteTime;

    @Column(name = "task_type")
    private String taskType;

    @Column(name = "mq_exchange")
    private String mqExchange;

    @Column(name = "mq_routingkey")
    private String mqRoutingkey;

    @Column(name = "request_body")
    private String requestBody;

    @Column(name = "status")
    private String status;

    @Column(name = "errormsg")
    private String errormsg;

}
