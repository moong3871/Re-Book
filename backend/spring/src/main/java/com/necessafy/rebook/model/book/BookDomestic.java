package com.necessafy.rebook.model.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@JsonInclude(JsonInclude.Include.NON_NULL)

public class BookDomestic {
    private String category;
    private String publisher;
    private String bookSummary;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String isbn;
    private String title;
    private int price;
    private String writer;
    private String bookImagePath;
    private String publishDate;
    private int evaluation;
    private int categoryId;
}
