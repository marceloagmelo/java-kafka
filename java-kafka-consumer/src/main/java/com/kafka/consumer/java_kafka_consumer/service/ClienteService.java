package com.kafka.consumer.java_kafka_consumer.service;

import com.kafka.consumer.java_kafka_consumer.constants.ApplicationConstants;
import com.kafka.consumer.java_kafka_consumer.record.ClienteRecord;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class ClienteService {

    @Autowired
    private ApiClientService apiClientService;

    // @KafkaListener(topics = "cliente", containerFactory =
    // "clienteKafkaListenerContainerFactory")
    @KafkaListener(topicPartitions = @TopicPartition(topic = "cliente", partitions = {
            "0" }), containerFactory = "clienteKafkaListenerContainerFactory")
    public void orderListener(ClienteRecord clienteRecord) throws IOException, InterruptedException {
        log.info("Received Message Cliente: {}", clienteRecord.nome());
        log.info("Received Message Ação: {}", clienteRecord.acao());

        if ("I".equals(clienteRecord.acao())) {
            HttpResponse<String> response = apiClientService.criar(clienteRecord);
            log.info("Status Code: {}", response.statusCode());
        } else if (ApplicationConstants.ALTERAR.equals(clienteRecord.acao())) {
            HttpResponse<String> response = apiClientService.alterar(clienteRecord);
            log.info("Status Code: {}", response.statusCode());
        } else if (ApplicationConstants.EXCLUIR.equals(clienteRecord.acao())) {
            HttpResponse<String> response = apiClientService.excluir(clienteRecord.id());
            log.info("Status Code: {}", response.statusCode());
        }

    }
}
