package com.nahom.chackduplicatecutomermain.entity;

import jakarta.persistence.*;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.UniqueConstraint;
// import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

// import javax.validation.constraints.Email;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.Size;


@Entity
@Table(name = "user2",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User2 {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;

    private String email;

    private String password;

   
    private String position;

//     @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(name = "user_roles",
//             joinColumns = @JoinColumn(name = "user_id"),
//             inverseJoinColumns = @JoinColumn(name = "role_id"))
//     private Set<Role> roles = new HashSet<>();
}
