package com.wanby.exercise.app;

import com.wanby.exercise.hadoop.kafka.DemoProducer;

public class KafkaApp {

	public static void main(String[] args) {
		DemoProducer producer = new DemoProducer("demo", true);
		producer.produceMessage();
	}

}
