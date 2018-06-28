package com.cainiao.exclusive.dubbo.util;

import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.util.StringUtils;

/**
 * Created by wangkecheng on 2018/6/28.
 */
public class MockClient {
    private String interfaceName;
    private String version;
    private Integer timeout;
    private volatile ServiceConfig<GenericService> service = null;

    public MockClient(MockServiceInfoDTO serviceInfo) {
        this.interfaceName = serviceInfo.getInterfaceName();
        this.version = serviceInfo.getVersion();
        this.timeout = serviceInfo.getTimeout();
    }

    public void start(GenericService T) {
        if(!StringUtils.isEmpty(this.interfaceName) && this.interfaceName.length() > 0) {
            this.service = new ServiceConfig();
            this.service.setInterface(this.interfaceName);
            if(this.version != "" && this.version.length() > 0) {
                this.service.setVersion(this.version);
            }

            if(this.timeout.toString() != "" && this.timeout.toString().length() > 0) {
                this.service.setTimeout(this.timeout);
            }

            this.service.setRef(T);
            this.service.export();
        } else {
            throw new RuntimeException("The \'interfaceName\' should not be " + this.interfaceName + ", please make sure you have the correct \'interfaceName\' passed in");
        }
    }

    public void stop(GenericService T) {
        this.service = new ServiceConfig();
        this.service.setInterface(this.interfaceName);
        if(this.version != "" && this.version.length() > 0) {
            this.service.setVersion(this.version);
        }

        if(this.timeout.toString() != "" && this.timeout.toString().length() > 0) {
            this.service.setTimeout(this.timeout);
        }

        this.service.setRef(T);
        this.service.unexport();
    }
}