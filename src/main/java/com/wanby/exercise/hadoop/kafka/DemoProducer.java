package com.wanby.exercise.hadoop.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wanby.exercise.prop.KafkaProperties;

/**
 * 
 * @Author wanby
 * @Version 1.0.00
 * Oct 18, 2017 7:25:36 PM
 */
public class DemoProducer {
	private final static Logger LOGGER = LoggerFactory.getLogger(DemoProducer.class);
	private KafkaProducer<String, String> kafkaProducer;
	private String topic;
	private Boolean isAsync;
	
	public DemoProducer(String topic, Boolean isAsync) {
		this.topic = topic;
		this.isAsync = isAsync;
	}
	
	public Properties getProp() {
		Properties props = new Properties();
		
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.KAFKA_SERVER);
		props.put("acks", "all");
		props.put("retries", 10);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		return props;
	}
	
	public void produceMessage() {
		kafkaProducer = new KafkaProducer<String, String>(getProp());
		
		for(int i = 101;i < 199;i++) {
			kafkaProducer.send(new ProducerRecord<String, String>("demo", Integer.toString(i), Integer.toString(i)));
			LOGGER.info("Kafka send messager " + Integer.toString(i) + ": " +  Integer.toString(i));
		}
		kafkaProducer.close();
	}

}
