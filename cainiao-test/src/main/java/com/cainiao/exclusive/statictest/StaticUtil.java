package com.cainiao.exclusive.statictest;

/**
 * Created by wangkecheng on 2018/7/31.
 */
public class StaticUtil {

    public static void staticTest(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("调用成功");
    }
}
