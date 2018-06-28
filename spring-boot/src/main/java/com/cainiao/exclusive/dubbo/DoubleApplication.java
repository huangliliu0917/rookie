package com.cainiao.exclusive.dubbo;

import com.alibaba.dubbo.rpc.service.GenericService;

import com.cainiao.exclusive.dubbo.manage.RecvCouponImpl;
import com.cainiao.exclusive.dubbo.util.MockClient;
import com.cainiao.exclusive.dubbo.util.MockServiceInfoDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * 对外提供double接口
 * <P>
 *     类描述
 * </P>
 * Created by wangkecheng on 2018/6/28.
 */
@SpringBootApplication
public class DoubleApplication {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        //领券接口
        MockServiceInfoDTO serviceInfo =  new MockServiceInfoDTO("com.bestpay.voucher.manage.api.IVoucherService","", 10000);
        GenericService genericService = RecvCouponImpl.class.newInstance();
        MockClient client = new MockClient(serviceInfo);

        try {
            client.start(genericService);
            SpringApplication.run(DoubleApplication.class, args);
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.stop(genericService);
            System.out.println("finally");
        }
    }
}
