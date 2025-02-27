package com.kafka.producer.java_kafka_producer.exception;

public class ClienteJaExistenteException extends Exception {

    public ClienteJaExistenteException() {
        super("Cliente já existe");
    }

    @Override
    public String toString() {
        return "Cliente já existe";
    }
}
