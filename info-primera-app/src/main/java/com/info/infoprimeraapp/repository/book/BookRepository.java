package com.info.infoprimeraapp.repository.book;

import com.info.infoprimeraapp.domain.Book;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

}
