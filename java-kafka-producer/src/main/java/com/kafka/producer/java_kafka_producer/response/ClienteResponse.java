package com.kafka.producer.java_kafka_producer.response;

import com.kafka.producer.java_kafka_producer.entity.Cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse {

    private String status;
    private String message;
    private Cliente cliente;

    public ClienteResponse(String status, String mensagem) {
        this.message = mensagem;
        this.status = status;
    }

    public ClienteResponse(String status, String mensagem, Cliente cliente) {
        this.message = mensagem;
        this.status = status;
        this.cliente = cliente;
    }

}
