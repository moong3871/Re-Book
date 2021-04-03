package com.necessafy.rebook.model.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.necessafy.rebook.model.book.Book;
import com.necessafy.rebook.model.user.UserRebook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserReadStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int status; //읽고 싶어요 0 읽고 있어요 1 읽었어요 2

    @ManyToOne
    @JoinColumn(name="USER_EMAIL")
    private UserRebook userRebook;

    @ManyToOne
    @JoinColumn(name="BOOK_ISBN")
    private Book book;



}
