package com.cainiao.exclusive.webservice;

import com.cainiao.exclusive.webservice.service.impl.PeopleServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by wangkecheng on 2018/7/23.
 */
public class SoapService {
    public static void main(String[] args) {
        /**
         * 方法一，使用javax.xml.ws.*包中的EndPoint的静态方法publish()发布Web服务
         * */
        toEndpointPublish();

    }

    private static void toEndpointPublish() {
        Endpoint.publish("http://127.0.0.1:8080/peopleService", new PeopleServiceImpl());
    }
}
