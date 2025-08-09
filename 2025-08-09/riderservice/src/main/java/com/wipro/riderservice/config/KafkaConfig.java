package com.wipro.riderservice.config;

import java.util.HashMap;
import java.util.Map;

import com.wipro.riderservice.dto.RideRequest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaConfig {

    @Bean(name = "riderProducerFactory")
    public ProducerFactory<String, RideRequest> riderProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean(name = "riderKafkaTemplate")
    public KafkaTemplate<String, RideRequest> riderKafkaTemplate() {
        return new KafkaTemplate<>(riderProducerFactory());
    }

    @Bean
    public ConsumerFactory<String, RideRequest> riderConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "rider-service-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        JsonDeserializer<RideRequest> deserializer = new JsonDeserializer<>(RideRequest.class);
        deserializer.ignoreTypeHeaders();
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RideRequest> riderKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, RideRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(riderConsumerFactory());
        return factory;
    }
}
