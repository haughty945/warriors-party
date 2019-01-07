package com.mine.warriorsservercommon.service;

import com.mine.warriorsservercommon.entity.LogServlet;

/**
 * @Author : mine_lee
 * @Date   : 2019-01-08
 * @Remark :【请求日志】代理层
 */
public interface ILogServletRepository{

   public void insertLogServlet(LogServlet entity);

   public LogServlet selectLogServlet(LogServlet entity);

   public void updateLogServlet(LogServlet entity);

}
