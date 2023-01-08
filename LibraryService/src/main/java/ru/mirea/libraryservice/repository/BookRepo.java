package ru.mirea.libraryservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mirea.libraryservice.entity.Book;

public interface BookRepo extends CrudRepository<Book, Long> {
    Book getBookById(Long id);
}
