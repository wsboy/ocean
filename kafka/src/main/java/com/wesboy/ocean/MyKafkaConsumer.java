package com.wesboy.ocean;

import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class MyKafkaConsumer extends ShutdownableThread {

    private final KafkaConsumer<Integer, String> consumer;

    public MyKafkaConsumer() {
        super("KafkaConsumerTest", false);
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, MyKafkaProperties.KAFKA_BROKER_LIST);
        //消息分组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "DemoGroup1");
        //是否自动提交消息
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        //自动提交的间隔时间
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        //设置使用最开始的offset偏移量为当前group.id的最早消息
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        //设置心跳时间
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        //对key和value设置反序列化对象
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer<>(properties);
    }

    @Override
    public void doWork() {
        consumer.subscribe(Collections.singletonList(MyKafkaProperties.TOPIC));
        ConsumerRecords<Integer, String> records = consumer.poll(1000L);
        for (ConsumerRecord records1 : records) {
            System.out.println("partition:[" + records1.partition() + "], receive message: " +
                    "[" + records1.key() + "->" + records1.value() + "], offset:[" + records1.offset() + "]");
        }
    }

    public static void main(String[] args) {
        MyKafkaConsumer consumer = new MyKafkaConsumer();
        consumer.start();
    }
}
