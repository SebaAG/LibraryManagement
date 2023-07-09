package com.info.infoprimeraapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
    private String telNumber;

    @Column(length = 255,columnDefinition = "varchar(255)", nullable = false)
    private String webSite;
}
