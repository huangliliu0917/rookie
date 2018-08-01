package com.cainiao.exclusive.context;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by wangkecheng on 2018/7/24.
 */
//@Component //监听器是web层的组件，它是tomcat实例化的，不是Spring实例化的。不能放到Spring中
public class InitDataListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {

}

    @Override
    public void contextInitialized(ServletContextEvent event) {
    // 获取业务逻辑类productService查询商品信息
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:/spring/application-context.xml");
      /*  DruidDataSource obj = (DruidDataSource)ac.getBean("dataSource");
        String str = obj.getUrl();
        System.out.println(str);*/
    }

}
