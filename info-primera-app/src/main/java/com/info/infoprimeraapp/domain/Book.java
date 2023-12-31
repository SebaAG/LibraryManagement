package com.info.infoprimeraapp.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Book {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy="org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID uuid;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String title;

    @ManyToOne
    private Author author;

    @Column(unique = true)
    private String isbn;

    private int numberPage;

    @ManyToMany
    @JoinTable(name = "book_category",joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    public void setAuthor(Author author) {
        this.author = author;
        author.getBooks().add(this);
    }

    public void addCategories(Category category){
        if (this.categories == null){
            this.categories = new ArrayList<>();
        }
        this.categories.add(category);
    }
}