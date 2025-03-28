package com.kafka.producer.java_kafka_producer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.producer.java_kafka_producer.entity.Cliente;
import com.kafka.producer.java_kafka_producer.exception.ClienteInexistenteException;
import com.kafka.producer.java_kafka_producer.exception.ClienteJaExistenteException;
import com.kafka.producer.java_kafka_producer.record.ClienteRecord;
import com.kafka.producer.java_kafka_producer.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getCliente(Integer id) throws ClienteInexistenteException {

        Cliente cliente = clienteRepository.findByIdCliente(id);

        if (cliente == null) {
            throw new ClienteInexistenteException();
        }

        return cliente;

    }

    public Cliente getCliente(String nomeCliente) throws ClienteInexistenteException {

        Cliente cliente = clienteRepository.findByNomeCliente(nomeCliente);

        if (cliente == null) {
            throw new ClienteInexistenteException();
        }

        return cliente;

    }

    public List<Cliente> getClientes() throws Exception {
        return clienteRepository.findAll();
    }

    public Cliente criar(ClienteRecord clienteRecord) throws ClienteJaExistenteException {
        Cliente cliente = clienteRepository.findByNomeCliente(clienteRecord.nome());

        if (cliente != null) {
            throw new ClienteJaExistenteException();
        }

        Cliente clienteNovo = new Cliente();
        clienteNovo.setNome(clienteRecord.nome());
        return clienteRepository.saveAndFlush(clienteNovo);
    }

    public Cliente alterar(int id, ClienteRecord clienteRecord) throws ClienteInexistenteException {
        Cliente cliente = clienteRepository.findByIdCliente(id);

        if (cliente == null) {
            throw new ClienteInexistenteException();
        }

        cliente.setNome(clienteRecord.nome());
        return clienteRepository.saveAndFlush(cliente);
    }

    public void excluir(int id) throws ClienteInexistenteException {
        Cliente cliente = clienteRepository.findByIdCliente(id);

        if (cliente == null) {
            throw new ClienteInexistenteException();
        }
        clienteRepository.deleteById(id);
    }
}
