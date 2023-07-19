package com.info.infoprimeraapp.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Category {

    @UuidGenerator
    @Id
    private UUID id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String categoryName;

    @ManyToMany
    @JoinTable(name = "book_category", joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books = new ArrayList<>();
}