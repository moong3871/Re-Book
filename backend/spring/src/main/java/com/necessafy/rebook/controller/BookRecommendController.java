package com.necessafy.rebook.controller;

import com.necessafy.rebook.Service.BookRecommendService;
import com.necessafy.rebook.Service.ResponseService;
import com.necessafy.rebook.model.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 책 추천에 대한 요청을 보낼 컨트롤러 생성
 */
@RestController
public class BookRecommendController {
    private final ResponseService responseService;
    private final BookRecommendService bookService;

    public BookRecommendController(ResponseService responseService, BookRecommendService bookService){
        this.responseService = responseService;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public CommonResult getBooks(){
        return responseService.getResult(bookService.getRecommendBooks());
    }
}
