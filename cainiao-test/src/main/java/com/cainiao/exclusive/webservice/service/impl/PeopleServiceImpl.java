package com.cainiao.exclusive.webservice.service.impl;

import com.cainiao.exclusive.webservice.service.PeopleService;

import javax.jws.WebService;

/**
 * Created by wangkecheng on 2018/7/23.
 */
@WebService(endpointInterface = "com.cainiao.exclusive.webservice.service.PeopleService")
public class PeopleServiceImpl implements PeopleService {

    @Override
    public String add(String arg0) {
        System.out.println("接口调用成功");
        return null;
    }
}
