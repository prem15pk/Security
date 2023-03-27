package com.springsecurity.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    private String email;
    private String password;
    private String role;

}
