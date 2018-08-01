package com.cainiao.exclusive.webservice.client;
/**
 * 第三方配置模型
 * @author wangkecheng
 *
 */
public class DelegateObj {
	/**
	 * wsdl url
	 */
	private String wsdlUrl; 
	/**
	 * 命名空间
	 */
	private String targetNameSpace;
	/**
	 * 服务名称
	 */
	private String wsdlServiceName;
	/**
	 * 发布的端口服务
	 */
	private String wsdlPortName;
	public String getWsdlUrl() {
		return wsdlUrl;
	}
	public void setWsdlUrl(String wsdlUrl) {
		this.wsdlUrl = wsdlUrl;
	}
	public String getTargetNameSpace() {
		return targetNameSpace;
	}
	public void setTargetNameSpace(String targetNameSpace) {
		this.targetNameSpace = targetNameSpace;
	}
	public String getWsdlServiceName() {
		return wsdlServiceName;
	}
	public void setWsdlServiceName(String wsdlServiceName) {
		this.wsdlServiceName = wsdlServiceName;
	}
	public String getWsdlPortName() {
		return wsdlPortName;
	}
	public void setWsdlPortName(String wsdlPortName) {
		this.wsdlPortName = wsdlPortName;
	}

	
	
}
