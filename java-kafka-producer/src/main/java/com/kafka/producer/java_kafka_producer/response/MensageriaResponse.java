package com.kafka.producer.java_kafka_producer.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensageriaResponse {

    private String status;
    private String message;

    public MensageriaResponse(String status, String mensagem) {
        this.message = mensagem;
        this.status = status;
    }

}
