package com.kafka.producer.java_kafka_producer.response;

import java.util.List;

import com.kafka.producer.java_kafka_producer.entity.Cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteListaResponse {

    private String status;
    private String message;
    private List<Cliente> cliente;

    public ClienteListaResponse(String status, String mensagem) {
        this.message = mensagem;
        this.status = status;
    }

    public ClienteListaResponse(String status, String mensagem, List<Cliente> cliente) {
        this.message = mensagem;
        this.status = status;
        this.cliente = cliente;
    }

}