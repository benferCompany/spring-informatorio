package com.info.infoprimeraapp.service.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.service.BookService;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl implements BookService {
    HashMap<UUID,Book> bookMap;
    public BookServiceImpl() {
       bookMap = new HashMap();
       
       Book book = new Book();
       book.setAuthor("autor");
       book.setTitle("TItle");
       book.setUuid(UUID.randomUUID());
       bookMap.put(book.getUuid(), book);
    }
    
    
    @Override
    public List<Book> getAllBooks() {
        
        return null;
    }

    
}
