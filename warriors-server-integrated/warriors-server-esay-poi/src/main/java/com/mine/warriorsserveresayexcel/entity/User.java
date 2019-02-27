package com.mine.warriorsserveresayexcel.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: warriors-party
 * @description:
 * @author: Mine.Lee
 * @create: 2019-02-27 10:40
 * @version: v1.0
 * @remark: ..
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Excel(orderNum = "0",name = "姓名",width = 30)
    private String name;

    @Excel(orderNum = "1", name = "性别",width=30,replace = { "男_1", "女_2" })
    private String sex;

    @Excel(orderNum = "2",name = "生日",width=50,format = "yyyy-MM-dd")
    private Date birthday;

}
