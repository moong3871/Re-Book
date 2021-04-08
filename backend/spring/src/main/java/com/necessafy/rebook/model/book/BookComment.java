package com.necessafy.rebook.model.book;

import com.necessafy.rebook.model.TimeEntity;
import com.necessafy.rebook.model.user.UserRebook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="BookComment")
@Data
public class BookComment extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    private Integer rating;

    @Column(length = 500)
    private String review;

    //unique 키 : USER_EMAIL, isbn
    @ManyToOne
    @JoinColumn(name="USER_EMAIL")
    private UserRebook userRebook;

    @ManyToOne()
    @JoinColumn(name="BOOK_ISBN")
    private Book book;



}
