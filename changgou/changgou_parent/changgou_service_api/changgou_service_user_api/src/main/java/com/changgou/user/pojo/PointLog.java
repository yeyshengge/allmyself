package com.changgou.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * Created by zps on 2020/2/6 17:15
 */
@Table(name="tb_point_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointLog {
    private String orderId;
    private String userId;
    private Integer point;
}
