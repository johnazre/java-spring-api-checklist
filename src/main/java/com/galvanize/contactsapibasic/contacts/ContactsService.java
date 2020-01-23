package com.galvanize.contactsapibasic.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactsService {

    @Autowired
    private final ContactsRepository contactsRepository;

    public ContactsService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public List<Contact> getAllContacts() {
        return this.contactsRepository.findAll();
    }

    public Optional<Contact> getOneContact(int id) {
        return contactsRepository.findById(id);
    }

    public Contact addOneContact(Contact newContact) {
        return contactsRepository.save(newContact);
    }

    public Contact updateOneContact(Contact updatedContact) {
        return contactsRepository.save(updatedContact);
    }

    public String removeOneContact(int id) {
        contactsRepository.deleteById(id);
        return "Id " + id + " was removed";
    }
}
