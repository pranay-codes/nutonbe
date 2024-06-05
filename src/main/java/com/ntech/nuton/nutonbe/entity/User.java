package com.ntech.nuton.nutonbe.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
    name = "users", 
    uniqueConstraints = @UniqueConstraint(
        name = "user_email_constraint",
        columnNames = "email_address"
    ))
public record User(
    @Id
    @SequenceGenerator(
        name = "user_id_seq", 
        sequenceName = "user_id_seq", 
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "user_id_seq"
    )
    @Column(
        name = "user_id"
    )
    Long userid, 

    @Column(
        name = "email_address",
        nullable = false,
        unique = true
    )
    String emailAddress, 

    @Column(
        name = "user_password",
        nullable = false,
        length = 60
    )
    String password, 

    @Column(
        name = "first_name",
        nullable = false
    )
    String firstName, 

    @Column(
        name = "last_name"
    )
    String lastName, 

    @Column(
        name = "date_of_birth",
        nullable = false
    )
    Timestamp dateOfBirth, 

    @Column(
        name = "status"
    )
    String status, 

    @Column(
        name = "modified_timestamp"
    )
    Timestamp modifiedTimestamp
    ) {
    
}
