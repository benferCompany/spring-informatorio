package com.info.infoprimeraapp.repository.book;

import com.info.infoprimeraapp.domain.Author;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    public Author findFirstByUuid(Long uuid);
    public Author findFirstByNameOrLastname(String name,String last_name);
}
