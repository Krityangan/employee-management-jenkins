package com.Employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.entity.Contact;

@Repository
public interface ContactReporsitory extends JpaRepository<Contact, Long> {

}
