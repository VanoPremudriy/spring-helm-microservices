package ru.mirea.libraryservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    Long id;

    @Column(name = "book_name")
    String name;

    @Column(name = "book_author")
    String author;

    @Column(name = "book_year")
    int year;

    @Column(name = "book_count")
    int count;

}
