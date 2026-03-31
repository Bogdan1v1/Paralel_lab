package com.example.demo.controllers;

import com.example.demo.dto.ClientCreateDTO;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@Valid @RequestBody ClientCreateDTO dto) {
        return clientService.createClient(dto);
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAllClients();
    }
}