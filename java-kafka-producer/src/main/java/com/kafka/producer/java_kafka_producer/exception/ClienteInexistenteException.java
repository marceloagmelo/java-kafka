package com.kafka.producer.java_kafka_producer.exception;

public class ClienteInexistenteException extends Exception {

    public ClienteInexistenteException() {
        super("Cliente não encontrado");
    }

    @Override
    public String toString() {
        return "Cliente não encontrado";
    }
}