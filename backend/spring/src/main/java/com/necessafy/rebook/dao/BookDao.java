
package com.necessafy.rebook.dao;

import com.necessafy.rebook.model.book.BookDomestic;
import com.necessafy.rebook.model.book.BookDomestic;
import com.necessafy.rebook.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookDao extends JpaRepository<BookDomestic, String> {
    Optional<BookDomestic> findBookByIsbn(String isbn);

    List<BookDomestic> findAll();
}
