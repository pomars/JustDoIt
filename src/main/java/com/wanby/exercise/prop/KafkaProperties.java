package com.wanby.exercise.prop;

public class KafkaProperties {
    public static final String TOPIC = "TOPIC_SESSION_DATA";
    public static final String KAFKA_SERVER = "192.168.1.163:9092,192.168.1.164:9092,192.168.1.165:9092";
    public static final int KAFKA_PRO_BUF_SIZE = 64 * 1024;
    public static final int KAFKA_CON_TIMEOUT = 100000;
    public static final String KAFKA_CLIENT_ID = "DemoProducer";
    public static final String KAFKA_ACKS = "all";
    public static final String KAFKA_RETRIES = "10";

    private KafkaProperties() {}
}
