package com.info.infoprimeraapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Publisher {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(length = 255,columnDefinition = "varchar(255)", nullable = false)
    private String publisherName;

    @Column(length = 255,columnDefinition = "varchar(255)", nullable = false)
    private String address;

    @Column(length = 255,columnDefinition = "varchar(255)", nullable = false)
    private String city;

    @Column(length = 255,columnDefinition = "varchar(255)", nullable = false)
    private String country;

    @Column(length = 255,columnDefinition = "varchar(255)", nullable = false)
    private String phone;

    @Column(length = 255,columnDefinition = "varchar(255)", nullable = false)
    private String web;
}
