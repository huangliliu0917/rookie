package com.cainiao.exclusive.dubbo.util;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

public abstract class AbstractServiceMock implements GenericService {
    public AbstractServiceMock() {
    }

    public Object $invoke(String s, String[] strings, Object[] objects) throws GenericException {
        return this.mockerDefiniton(s, strings, objects);
    }

    public abstract Object mockerDefiniton(String var1, String[] var2, Object[] var3);
}