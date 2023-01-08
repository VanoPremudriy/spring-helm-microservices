package ru.mirea.libraryservice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBooks {

    @Id
    Long id;

    @Column(name = "user_id")
    Long userId;

    @Column(name = "book_id")
    Long bookId;
}
