package com.restApiProject.restApi.controller;


import com.restApiProject.restApi.model.ContactInfo;
import com.restApiProject.restApi.response.ResponseHandler;
import com.restApiProject.restApi.service.ContactService;
import com.restApiProject.restApi.service.impl.ContactServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController
{
    ContactServiceImpl contactService;

    public ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    // Read Specific contact Details from DB
    @GetMapping("/{contactId}")
    @ApiOperation(value ="contact id", notes="Provide contact details", response = ResponseEntity.class)
    public ResponseEntity<Object> getContactDetails(@PathVariable("contactId") Long contactId)
    {
       return ResponseHandler.responseBuilder("Requested Contact Details are given here",
                HttpStatus.OK, contactService.getContact(contactId));
    }

    // Read All Contact Details from DB
    @GetMapping("/")
    public List<ContactInfo> getAllContactDetails()
    {
        return contactService.getAllContact();
    }

    // Creating a contact
    @PostMapping("/")
    public String createContactDetails(@RequestBody ContactInfo contactInfo)
    {
        contactService.createContact(contactInfo);
        return "Contact Created Successfully";
    }

    // Updating a contact
    @PutMapping("/{contactId}")
    public String updateContactDetails(@PathVariable("contactId") Long contactId ,@RequestBody ContactInfo contactInfo)
    {
        contactService.updateContact(contactInfo,contactId);
        return "Contact Updated Successfully";
    }

    @DeleteMapping("/{contactId}")
    public String deleteContactDetails(@PathVariable("contactId") Long contactId)
    {
        contactService.deleteContact(contactId);
        return "Contact Deleted Successfully";
    }

    // Get All Contacts Details by First Name from DB
    @GetMapping("/firstName/{firstName}")
    @ApiOperation(value ="First Name", notes="Provide First Name ", response = ResponseEntity.class)
    public ResponseEntity<Object> getContactDetailsByFirstName(@PathVariable("firstName") String firstName)
    {
        return ResponseHandler.responseBuilder("Requested Contact Details are given here",
                HttpStatus.OK, contactService.getByFirstName(firstName));
    }

    // Get All Contacts Details by Last Name from DB
    @GetMapping("/lastName/{lastName}")
    @ApiOperation(value ="Last Name", notes="Provide Last Name ", response = ResponseEntity.class)
    public ResponseEntity<Object> getContactDetailsByLastName(@PathVariable("lastName") String lastName)
    {
        return ResponseHandler.responseBuilder("Requested Contact Details are given here",
                HttpStatus.OK, contactService.getByLastName(lastName));
    }

    // Get All Contacts Details by Email Address from DB
    @GetMapping("/emailAddress/{emailAddress}")
    @ApiOperation(value ="Email Address", notes="Provide Email Address ", response = ResponseEntity.class)
    public ResponseEntity<Object> getContactDetailsByEmailAddress(@PathVariable("emailAddress") String emailAddress)
    {
        return ResponseHandler.responseBuilder("Requested Contact Details are given here",
                HttpStatus.OK, contactService.getByEmailAddress(emailAddress));
    }

    // Get All Contacts Details by Phone Number from DB
    @GetMapping("/phoneNumber/{phoneNumber}")
    @ApiOperation(value ="Phone Number", notes="Provide Phone Number", response = ResponseEntity.class)
    public ResponseEntity<Object> getContactDetailsByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber)
    {
        return ResponseHandler.responseBuilder("Requested Contact Details are given here",
                HttpStatus.OK, contactService.getByPhoneNumber(phoneNumber));
    }


}
