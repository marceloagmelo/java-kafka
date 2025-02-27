package com.kafka.consumer.java_kafka_consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.kafka.consumer.java_kafka_consumer.record.ClienteRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ApiClientService {

    @Value(value = "${clientes.endpoint}")
    private String clientesEndpoint;

    private final HttpClient client;
    private final ObjectMapper objectMapper;

    public ApiClientService() {
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }

    public HttpResponse<String> criar(ClienteRecord clienteRecord) throws IOException, InterruptedException {
        String body = objectMapper.writeValueAsString(clienteRecord);
        System.out.println(body);
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(clientesEndpoint))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> alterar(ClienteRecord clienteRecord) throws IOException, InterruptedException {
        String body = objectMapper.writeValueAsString(clienteRecord);
        System.out.println(body);
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(clientesEndpoint + "/" + clienteRecord.id()))
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> excluir(Integer id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(clientesEndpoint + "/" + id))
                .DELETE()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
