package com.cainiao.exclusive.webservice.client;

import com.huateng.util.MacUtil;
import com.huateng.util.Md5;
import com.ideal.util.ThreeDes;

/**
 * Created by wangkecheng on 2018/7/30.
 */
public class WebServiceTest {
    public static void main(String[] args) {
        String wsdlUrl = "http://116.228.151.160:48037/billfront/services/businessService?wsdl";
        WebServiceExcuteDelegate delegate = null;
        try {
            delegate = DelegateFactory.getDeletegate(wsdlUrl, "http://control.ppcore.haobai.huateng.com", "IDispatchControl", "IDispatchControlHttpPort",WebServiceExcuteDelegate.class);

            String encryptvoucherpin =  ThreeDes.desEncrypt("CHANNELCODE=0990000002&SERNUM=20180731100712&VOUCHER_NO=0111001806150000459", "3536363832343930");

            String md5Params = getMd5Params(encryptvoucherpin);

            String md5 = MacUtil.genMac(md5Params,"3536363832343930");

            String in0 = "B00009|0770000001|V1.0|124.74.76.126|";

            String in1 = reqXml(encryptvoucherpin,md5);

            System.out.println(in1);

            String str = delegate.dispatchCommand(in0,in1);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *拼装发送给第三方的报文
     * @return
     */
    public static String reqXml(String encryptvoucherpin,String md5){
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        builder.append("<PayPlatRequestParameter>");
        builder.append("<CTRL-INFO");
        builder.append(" WEBSVRNAME="); builder.append("\"卡信息查询\"");
        builder.append(" WEBSVRCODE="); builder.append("\"B00009\"");
        builder.append(" APPFROM="); builder.append("\"0770000001\"");
        builder.append(" SERNUM=");  builder.append("\"" + "20180731100712" + "\"");
        builder.append(" APPDATE="); builder.append("\"" + "20180731" + "\"");
        builder.append(" APPTIME="); builder.append("\"" + "100708" + "\"");
        builder.append("/>");
        builder.append("<PARAMETERS>");
        builder.append("<BILLORGID>");builder.append("9999009999019006");builder.append("</BILLORGID>");
        builder.append("<ENCRYPTVOUCHERPIN>");builder.append(encryptvoucherpin);builder.append("</ENCRYPTVOUCHERPIN>");
        builder.append("<TEXT1></TEXT1>");
        builder.append("<TEXT2></TEXT2>");
        builder.append("<TEXT3></TEXT3>");
        builder.append("<TEXT4></TEXT4>");
        builder.append("<TEXT5></TEXT5>");
        builder.append("</PARAMETERS>");
        builder.append("<MAC>"); builder.append(md5); builder.append("</MAC>");
        builder.append("</PayPlatRequestParameter>");
        String xmlStr = builder.toString();
        return xmlStr;
    }

    //销账缴费报文体
    public static String getMd5Params(String encryptvoucherpin) {
        StringBuilder str = new StringBuilder();
        str.append("<BILLORGID>");
        str.append("9999009999019006");
        str.append("</BILLORGID>");
        str.append("<ENCRYPTVOUCHERPIN>");
        str.append(encryptvoucherpin);
        str.append("</ENCRYPTVOUCHERPIN>");
        str.append("<TEXT1>");
        str.append("</TEXT1>");
        str.append("<TEXT2>");
        str.append("</TEXT2>");
        str.append("<TEXT3>");
        str.append("</TEXT3>");
        str.append("<TEXT4>");
        str.append("</TEXT4>");
        str.append("<TEXT5>");
        str.append("</TEXT5>");

        String data = str.toString();
        return data;
    }
}
