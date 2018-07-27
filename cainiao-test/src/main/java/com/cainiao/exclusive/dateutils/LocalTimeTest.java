package com.cainiao.exclusive.dateutils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by wangkecheng on 2018/7/26.
 */
public class LocalTimeTest {
    public static void main(String[] args) {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMM")));
    }
}
