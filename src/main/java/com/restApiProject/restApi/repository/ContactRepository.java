package com.restApiProject.restApi.repository;

import com.restApiProject.restApi.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<ContactInfo, Long> {
    @Query(value = "SELECT * FROM contactinfo.my_contacts WHERE first_name = ?1", nativeQuery = true)
    List<ContactInfo> findByFirstName(String firstName);
    @Query(value = "SELECT * FROM contactinfo.my_contacts WHERE last_name = ?1", nativeQuery = true)
    List<ContactInfo> findByLastName(String lastName);
    @Query(value = "SELECT * FROM contactinfo.my_contacts WHERE email_address = ?1", nativeQuery = true)
    List<ContactInfo> findByEmailAddress(String emailAddress);
    @Query(value = "SELECT * FROM contactinfo.my_contacts WHERE phone_number = ?1", nativeQuery = true)
    List<ContactInfo> findByPhoneNumber(String phoneNumber);

}
