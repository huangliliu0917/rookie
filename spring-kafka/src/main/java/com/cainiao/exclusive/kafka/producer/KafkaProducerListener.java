package com.cainiao.exclusive.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

/**
 * kafkaProducer监听器，在producer配置文件中开启
 * @author wangkecheng
 *
 */
@Slf4j
public class KafkaProducerListener implements ProducerListener{
    /**
     * 发送消息成功后调用
     */
    @Override
    public void onSuccess(String topic, Integer partition, Object key,
                          Object value, RecordMetadata recordMetadata) {
        log.info("==========kafka发送数据成功（日志开始）==========");
        log.info("----------topic:"+topic);
        log.info("----------partition:"+partition);
        log.info("----------key:"+key);
        log.info("----------value:"+value);
        log.info("----------RecordMetadata:"+recordMetadata);
        log.info("~~~~~~~~~~kafka发送数据成功（日志结束）~~~~~~~~~~");
    }

    /**
     * 发送消息错误后调用
     */
    @Override
    public void onError(String topic, Integer partition, Object key,
                        Object value, Exception exception) {
        log.info("==========kafka发送数据错误（日志开始）==========");
        log.info("----------topic:"+topic);
        log.info("----------partition:"+partition);
        log.info("----------key:"+key);
        log.info("----------value:"+value);
        log.info("----------Exception:"+exception);
        log.info("~~~~~~~~~~kafka发送数据错误（日志结束）~~~~~~~~~~");
        exception.printStackTrace();
    }

    /**
     * 方法返回值代表是否启动kafkaProducer监听器
     */
    @Override
    public boolean isInterestedInSuccess() {
        log.info("///kafkaProducer监听器启动///");
        return true;
    }

}