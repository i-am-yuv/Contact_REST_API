package com.restApiProject.restApi.service;


import com.restApiProject.restApi.model.ContactInfo;

import java.util.List;

public interface ContactService {
    public String createContact(ContactInfo contactInfo);
    public String updateContact(ContactInfo contactInfo, Long contactId);
    public String deleteContact(Long contactId);
    public ContactInfo getContact(Long contactId);
    public List<ContactInfo> getAllContact();
    public List<ContactInfo> getByFirstName(String firstName);
    public List<ContactInfo> getByLastName(String lastName);
    public List<ContactInfo> getByEmailAddress(String emailAddress);
    public List<ContactInfo> getByPhoneNumber(String phoneNumber);
}
