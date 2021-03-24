package com.necessafy.rebook.controller;

import com.necessafy.rebook.dao.BookDao;
import com.necessafy.rebook.model.CommonResult;
import com.necessafy.rebook.model.book.BookDomestic;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
//    BookService

    @Autowired
    BookDao bookDao;

    // 책 상세정보 반환
    @GetMapping("/{isbn}")
    @ApiOperation(value = "전체 공개 게시물을 받아온다", response = CommonResult.class)
    public CommonResult retrieveBookDetail(@PathVariable String isbn){
//        BookResponse bookResponse = ;
        CommonResult commonResult = new CommonResult();
        Optional<BookDomestic> book = bookDao.findBookByIsbn(isbn);
        commonResult.status = true;
        commonResult.data = "책 상세정보 반환에 성공하였습니다.";
        commonResult.object = book.get();
        System.out.println(commonResult.data);
        System.out.println("hell"+commonResult.object + " 책 정보입니다!!");
        return commonResult;
//        return new CommonResult(true, "책 상세정보 반환에 성공하였습니다.", book.get());
    }

    // 책 상세정보 반환
    @GetMapping("/all")
    @ApiOperation(value = "전체 공개 게시물을 받아온다", response = CommonResult.class)
    public CommonResult retrieveAllBook(){
//        BookResponse bookResponse = ;
        CommonResult commonResult = new CommonResult();
        List<BookDomestic> bookList = bookDao.findAll();
        commonResult.status = true;
        commonResult.data = "책 상세정보 반환에 성공하였습니다.";
        commonResult.object = bookList;
        System.out.println(commonResult.data);
        System.out.println("hell"+commonResult.object + " 책 정보입니다!!");
        return commonResult;
//        return new CommonResult(true, "책 상세정보 반환에 성공하였습니다.", book.get());
    }

    // 5star rating으로 특정 책의 평점을 등록 및 수정
    @PutMapping("/{bookId}")
    public void updateBookEvaluation(@PathVariable String bookId){

    }
}
