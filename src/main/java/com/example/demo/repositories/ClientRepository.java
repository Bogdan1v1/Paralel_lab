package com.example.demo.repositories;

import com.example.demo.models.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClientRepository {
    private final List<Client> clients = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Client save(Client client) {
        if (client.getId() == null) {
            client.setId(idGenerator.getAndIncrement());
        }
        clients.add(client);
        return client;
    }

    public List<Client> findAll() {
        return new ArrayList<>(clients);
    }

    public Optional<Client> findById(Long id) {
        return clients.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst();
    }
}