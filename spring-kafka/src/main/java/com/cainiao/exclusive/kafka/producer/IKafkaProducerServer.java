package com.cainiao.exclusive.kafka.producer;

/**
 * Created by wangkecheng on 2018/8/6.
 */
public interface IKafkaProducerServer{

    public boolean sndMsgForTemplate(String topic, Object data);

    public boolean sndMesForTemplate(String topic, Integer partitionNum, String key, Object value);
}
