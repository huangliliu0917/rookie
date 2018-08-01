package com.cainiao.exclusive.webservice.client;

import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import org.apache.http.conn.ConnectTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 本类提供访问第三方库使用的信息
 * @author HUANGXIYAO
 *
 */
public class DelegateFactory {
	private static Logger logger = LoggerFactory.getLogger(DelegateFactory.class);
	
	private DelegateFactory() {
	    throw new IllegalAccessError("Utility class");
	}
	/**
	 * 连接超时
	 */
	private static int CONNECTIMEOUT=3;
	/**
	 * 请求超时
	 */
	private static int READTIMEOUT=6000;
	/**
	 * 第三方对象库
	 */
	private static ConcurrentHashMap<String, Object> deleteMap = new ConcurrentHashMap<String, Object>();
	
	/**
	 * 可以改变要请求接口的超时时间
	 *例如： <service name="BusinessServiceImplService">
				<port name="BusinessServiceImplPort" binding="tns:BusinessServiceImplPortBinding">
					<soap:address location="http://127.0.0.1:8900/test"/>
				</port>
		  </service>
	 * @param wsdlurl 要访问的地址："http:*******?wsdl"
	 * @param targetNameSpace targetNamespace="http://servertest.webservice.hxy.com/"
	 * @param serviceName
	 * @param portName 
	 * @param t 类的字节码
	 * @param connectTimeOut 连接超时时间
	 * @param readTimeOut 请求超时时间
	 * @return
	 */
	public static <T> T getDeletegate(String wsdlurl,String targetNameSpace,String serviceName,String portName,Class<T> t,int connectTimeOut,int readTimeOut) throws ConnectTimeoutException, ConnectException{
		Object obj = deleteMap.get(wsdlurl);
		if(obj != null){
			return (T) obj;
		}
		//第一个参数为服务发布的targetNameSpace，可以通过查看对应的wsdl文件获得，默认是发布Service所在包的包名倒过来的形式；第二个参数是serviceName  
		QName serviceQName = new QName(targetNameSpace, serviceName);  
		////第一个参数是服务发布的targetNameSpace，第二个参数是portName 
		QName portQName = new QName(targetNameSpace, portName);  
		URL url = null;
		T deletegate = null;
		Service service = null;
		try {
			url = new URL(wsdlurl);
			//初始化第三方服务
			service = Service.create(url, serviceQName);
			//获取第三方服务接口引用对象
			deletegate = service.getPort(portQName, t);
			Map<String, Object> requestContext = ((BindingProvider) deletegate).getRequestContext();
			requestContext.put("thread.local.request.context", "true");
			// 设置连接超时时间
			requestContext.put("com.sun.xml.internal.ws.connect.timeout", connectTimeOut);
			// 设置请求超时时间
			requestContext.put("com.sun.xml.internal.ws.request.timeout", readTimeOut);
			deleteMap.put(wsdlurl, deletegate);
			return deletegate;
		} catch (MalformedURLException e) {
			logger.error("Http协议异常异常！");
		}
		return deletegate;
	}
	
	/**
	 * 默认接口的连接时间是1秒，请求时间是60秒
	 *例如： <service name="BusinessServiceImplService">
				<port name="BusinessServiceImplPort" binding="tns:BusinessServiceImplPortBinding">
					<soap:address location="http://127.0.0.1:8900/test"/>
				</port>
		  </service>
	 * @param wsdlurl 要访问的地址："http:*******?wsdl"
	 * @param targetNameSpace targetNamespace="http://servertest.webservice.hxy.com/"
	 * @param serviceName
	 * @param portName 
	 * @param t 类的字节码
	 * @return
	 * @throws java.net.ConnectException
	 * @throws ConnectTimeoutException
	 */
	public static <T> T getDeletegate(String wsdlurl,String targetNameSpace,String serviceName,String portName,Class<T> t) throws ConnectTimeoutException, ConnectException{
		T deletegate = getDeletegate(wsdlurl,targetNameSpace,serviceName,portName,t, CONNECTIMEOUT,READTIMEOUT);
		return deletegate;
	}
	
	/**
	 * 根据第三方码获取需要访问第三方商户的对象
	 * @param thirdCode
	 * @param t
	 * @return
	 */
	public static <T> T getDeletegate(String thirdCode, Class<T> t){
		DelegateObj delObj = new DelegateObj();
		//执行数据库查询
		try {
			logger.info("第三方码是：{}",thirdCode);
			return getDeletegate(delObj.getWsdlUrl(),delObj.getTargetNameSpace(),delObj.getWsdlServiceName(),delObj.getWsdlPortName(),t);
		} catch (ConnectTimeoutException e) {
			logger.error("SOAP连接发生超时异常",e);
		} catch (ConnectException e) {
			logger.error("SOAP连接发生异常",e);
		}
		return null;
	}
}
