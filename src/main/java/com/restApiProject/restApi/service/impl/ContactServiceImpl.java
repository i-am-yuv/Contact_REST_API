package com.restApiProject.restApi.service.impl;

import com.restApiProject.restApi.exception.ContactNotFoundException;
import com.restApiProject.restApi.model.ContactInfo;
import com.restApiProject.restApi.repository.ContactRepository;
import com.restApiProject.restApi.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public String createContact(ContactInfo contactInfo) {
        // More Business Logic
        contactRepository.save(contactInfo);
        return "Success";
    }

    @Override
    public String updateContact(ContactInfo contactInfo , Long contactId ) {

        contactRepository.deleteById(contactId);
        contactRepository.save(contactInfo);
        return "Success";
    }

    @Override
    public String deleteContact(Long contactId) {
        // More Business Logic
        if(contactRepository.findById(contactId).isEmpty() )
            throw new ContactNotFoundException("Requested Contact does not exist");
        contactRepository.deleteById(contactId);
        return "Success";
    }

    @Override
    public ContactInfo getContact(Long contactId) {
        // More Business Logic
        if(contactRepository.findById(contactId).isEmpty())
            throw new ContactNotFoundException("Requested Contact does not exist");
        return contactRepository.findById(contactId).get();
    }

    @Override
    public List<ContactInfo> getAllContact() {
        // More Business Logic
        return contactRepository.findAll();
    }

    @Override
    public List<ContactInfo> getByFirstName(String firstName)
    {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    public List<ContactInfo> getByLastName(String lastName)
    {
        return contactRepository.findByLastName(lastName);
    }

    @Override
    public List<ContactInfo> getByEmailAddress(String emailAddress)
    {
        return contactRepository.findByEmailAddress(emailAddress);
    }

    @Override
    public List<ContactInfo> getByPhoneNumber(String phoneNumber)
    {
        return contactRepository.findByPhoneNumber(phoneNumber);
    }
}
