package com.springsecurity.Controller;

import com.springsecurity.Entity.Customer;
import com.springsecurity.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiginUpController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("saveCustomer")
    public ResponseEntity<Object> saveUser(@RequestBody Customer customer) {

        ResponseEntity response = null;
        try {
            String password = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(password);
            Customer c = customerRepository.save(customer);
            if (c.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Saved");
            }
        } catch (Exception exception) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());

        }
        return response;
    }
}