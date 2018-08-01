package com.cainiao.exclusive.webservice.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * Created by wangkecheng on 2018/7/30.
 * http://service.webservice.exclusive.cainiao.com/
 *
 */
@WebService(name = "IDispatchControl", targetNamespace = "http://control.ppcore.haobai.huateng.com")
public interface WebServiceExcuteDelegate {
    /**
     *
     * @param in0
     * @param in1
     * @return returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://control.ppcore.haobai.huateng.com")
    @RequestWrapper(localName = "dispatchComm", targetNamespace = "http://control.ppcore.haobai.huateng.com", className = "com.huateng.haobai.ppcore.control.DispatchComm")
    @ResponseWrapper(localName = "dispatchCommResponse", targetNamespace = "http://control.ppcore.haobai.huateng.com", className = "com.huateng.haobai.ppcore.control.DispatchCommResponse")
    public String dispatchCommand(
            @WebParam(name = "in0", targetNamespace = "http://control.ppcore.haobai.huateng.com")
            String in0,
            @WebParam(name = "in1", targetNamespace = "http://control.ppcore.haobai.huateng.com")
            String in1);

}
