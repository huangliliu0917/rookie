package com.cainiao.exclusive;

import com.cainiao.exclusive.kafka.producer.IKafkaProducerServer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class KafkaProducerTest extends BaseSpringTest{

    @Autowired
    private IKafkaProducerServer kafkaProducerServer;

    @Test
    public void sendMsg() {
        String topic = "test";
        boolean flag = kafkaProducerServer.sndMsgForTemplate(topic,"this frist msg");
        System.out.println(flag);
    }

    @Test
    public void getMsg() throws InterruptedException {
        Thread.sleep(100000);
    }
}