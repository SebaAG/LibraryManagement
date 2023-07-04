package com.info.infoprimeraapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.time.LocalDate;
import java.util.Objects;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 40,columnDefinition = "varchar(40)", nullable = false)
    private String name;

    @Column(length = 40,columnDefinition = "varchar(40)",nullable = false)
    private String lastName;

    @Column(length = 40,columnDefinition = "varchar(40)",nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        if (!Objects.equals(name, author.name)) return false;
        if (!Objects.equals(lastName, author.lastName)) return false;
        return Objects.equals(birth, author.birth);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        return result;
    }
}
