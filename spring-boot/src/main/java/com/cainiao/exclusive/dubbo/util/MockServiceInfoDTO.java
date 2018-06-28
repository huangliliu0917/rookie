package com.cainiao.exclusive.dubbo.util;

/**
 * Created by wangkecheng on 2018/6/28.
 */
public class MockServiceInfoDTO {
    private String interfaceName;
    private String version;
    private Integer timeout;

    public MockServiceInfoDTO(String interfaceName, String version, Integer timeout) {
        this.interfaceName = interfaceName;
        this.version = version;
        this.timeout = timeout;
    }

    public String getInterfaceName() {
        return this.interfaceName;
    }

    public Integer getTimeout() {
        return this.timeout;
    }

    public String getVersion() {
        return this.version;
    }
}
