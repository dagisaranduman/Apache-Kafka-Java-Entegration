package com.bigdatacompany.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerApp {
    public static void main(String[] args) {

        Properties config = new Properties();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, new StringDeserializer().getClass().getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, new StringDeserializer().getClass().getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "BigdataTeam1");
        config.put(ConsumerConfig.CLIENT_ID_CONFIG, "exam1");

        KafkaConsumer<String,String> kafkaConsumer = new KafkaConsumer<String, String>(config);

        kafkaConsumer.subscribe(Arrays.asList("search"));

        /**
         * sürekli veri çek(Duration.ZERO ile) ve çektiğin verileri ConsumerRecords'a string string şeklinde at
         */
        while (true){
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ZERO);

            /**
             * gönderilen dataları okumak için
             */
            for(ConsumerRecord<String, String> rec : records)
                System.out.println(rec.value());

        }

    }
}