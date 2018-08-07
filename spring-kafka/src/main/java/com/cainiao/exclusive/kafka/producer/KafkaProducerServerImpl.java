package com.cainiao.exclusive.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * kafkaProducer模板
 * 	使用此模板发送消息
 * @author wangb
 *
 */
@Service
@Slf4j
public class KafkaProducerServerImpl implements IKafkaProducerServer {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    /**
     * 发送kafka消息
     * @param topic
     * @param data
     * @return
     */
    public boolean sndMsgForTemplate(String topic,Object data){
        ListenableFuture<SendResult<String,Object>> listenableFuture = kafkaTemplate.send(topic, data);
        return parseResultData(listenableFuture);
    }

    /**
     * kafka发送消息模板
     * @param topic 主题
     * @param partitionNum 分区数 如果使用分区,分区数必须大于0
     * @param key
     * @param value
     */
    public boolean sndMesForTemplate(String topic,Integer partitionNum,String key,Object value) {
        ListenableFuture<SendResult<String, Object>> listenableFuture = kafkaTemplate.send(topic,partitionNum,key,value);
        return parseResultData(listenableFuture);
    }
    /**
     * 解析kafka返回的数据
     * @param res
     * @return
     */
    private boolean parseResultData(ListenableFuture<SendResult<String, Object>> res){
        boolean flag = false;
        if(res!=null){
            try {
                SendResult r = res.get();//检查result结果集
				/*检查recordMetadata的offset数据，不检查producerRecord*/
                Long offsetIndex = r.getRecordMetadata().offset();
                if(offsetIndex!=null && offsetIndex>=0){
                   log.info("kafka发送数据成功");
                    flag = true;
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage(),e);
            } catch (ExecutionException e) {
                log.error(e.getMessage(),e);
            }
        }else{
           log.info("kafka返回结果为空");
        }
        return flag;
    }
}