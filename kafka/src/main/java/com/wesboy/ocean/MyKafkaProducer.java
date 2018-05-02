package com.wesboy.ocean;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;

public class MyKafkaProducer {

    private final KafkaProducer<Integer, String> producer;

    private final String topic;


    public MyKafkaProducer(String topic) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", MyKafkaProperties.KAFKA_BROKER_LIST);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("client.id", "producerDemo");

        this.producer = new KafkaProducer<>(properties);
        this.topic = topic;
    }

    public void sendMsg() {
        producer.send(new ProducerRecord<>(topic, "message"), (recordMetadata, e) -> {
            System.out.println("message send to: [" + recordMetadata.partition() + "]," +
                    "offset: [" + recordMetadata.offset() + "]");
        });
    }

    public static void main(String[] args) {
        MyKafkaProducer producer = new MyKafkaProducer(MyKafkaProperties.TOPIC);
        producer.sendMsg();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
