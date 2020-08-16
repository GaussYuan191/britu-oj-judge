package com.britu.oj.judge;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

public class ConsumerTest {

    private static DefaultMQPushConsumer pushConsumer;

    public static void main(String[] args) throws MQClientException {

        pushConsumer = new DefaultMQPushConsumer("judgeConsumerGroup1");
        pushConsumer.setNamesrvAddr("39.106.134.120::9876");
        pushConsumer.setConsumeThreadMax(Integer.parseInt("20"));
        pushConsumer.setConsumeThreadMin(Integer.parseInt("10"));
        pushConsumer.setMessageModel(MessageModel.CLUSTERING);
        pushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        pushConsumer.subscribe("ojcode1", "*");
        //设置实例名称
        pushConsumer.setInstanceName("consumer");
        //监听消息
        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                //获取消息
                System.out.println(1);
                for(MessageExt ext:msgs){
                    //RocketMQ由于是集群环境，所以产生的消息ID可能会重复
                    System.out.println(ext.getMsgId()+"----------"+new String(ext.getBody()));
                }
                System.out.println(2);
                //接受消息状态 1.消费成功    2.消费失败   队列还有
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者
        pushConsumer.start();
    }
}
