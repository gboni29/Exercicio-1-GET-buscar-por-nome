package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/search")
    public List<Contact> buscarPorNome(@RequestParam("name") String nome) {
        return contactRepository.findByNomeContainingIgnoreCase(nome);
    }

    @PostMapping
    public Contact criar(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }
}