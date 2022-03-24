package com.bookxchange.repositories;

import com.bookxchange.model.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {

    boolean existsByIsbn(String providedIsbn);

    BooksEntity getByIsbn(String providedIsbn);

    @Modifying
    @Query(value = "UPDATE books SET quantity = quantity+1 where isbn = ?1", nativeQuery = true)
    void updateToSent(String isbn);

}
