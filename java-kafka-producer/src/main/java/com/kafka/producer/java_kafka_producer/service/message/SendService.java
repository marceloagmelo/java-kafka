package com.kafka.producer.java_kafka_producer.service.message;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.producer.java_kafka_producer.constants.ApplicationConstants;
import com.kafka.producer.java_kafka_producer.record.ClienteRecord;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SendService {

    private final KafkaTemplate<String, ClienteRecord> kafkaTemplateOrder;

    public SendService(KafkaTemplate<String, ClienteRecord> kafkaTemplateOrder) {
        this.kafkaTemplateOrder = kafkaTemplateOrder;
    }

    @SuppressWarnings("null")
    public void sendMessageCliente(ClienteRecord cliente) {
        int partition = 0;
        log.info("Sent message to partition {}: ", partition);
        log.info("Sending Order: {}", cliente.nome());
        log.info("Sending Ação: {}", cliente.acao());
        kafkaTemplateOrder.send(ApplicationConstants.TOPIC_CLIENTE, partition, null, cliente);
    }

}
