package com.info.infoprimeraapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Review {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(length = 255,columnDefinition = "varchar(255)", nullable = false)
    private String title;

    @Column(length = 255,columnDefinition = "varchar(255)", nullable = false)
    private String bookName;

    @Column(length = 255,columnDefinition = "varchar(255)", nullable = false)
    private String content;

    @Column(length = 255,columnDefinition = "varchar(255)", nullable = false)
    private BigDecimal rate;

    @Column(length = 40,columnDefinition = "varchar(40)",nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}