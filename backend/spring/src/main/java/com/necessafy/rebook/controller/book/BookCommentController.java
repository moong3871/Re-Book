package com.necessafy.rebook.controller.book;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.necessafy.rebook.Service.book.CommentService;
import com.necessafy.rebook.Service.jwt.JwtService;
import com.necessafy.rebook.dao.account.UserRebookDao;
import com.necessafy.rebook.dao.book.BookCommentDao;
import com.necessafy.rebook.dao.book.BookDao;
import com.necessafy.rebook.model.book.Book;
import com.necessafy.rebook.model.book.BookComment;
import com.necessafy.rebook.model.book.CommentRequest;
import com.necessafy.rebook.model.user.UserRebook;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.necessafy.rebook.utils.HttpUtils.makeResponse;
import static com.necessafy.rebook.utils.HttpUtils.convertObjectToJson;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class BookCommentController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRebookDao userRebookDao;
    @Autowired
    private CommentService commentService;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookCommentDao bookCommentDao;

    @PutMapping
    @ApiOperation(value="리뷰 등록")
    public Object create(@ModelAttribute @ApiParam(value="리뷰 등록 시 필요한 정보(평점, 날짜, 내용) " +
            "이미 등록했던 리뷰면 수정만 가능"
    ,required = true) CommentRequest commentRequest,HttpServletRequest httpServletRequest){

        Integer rating=commentRequest.getRating();
        String review=commentRequest.getReview().trim();
        String userEmail=commentRequest.getUserEmail().trim();
        String isbn=commentRequest.getIsbn().trim();
        String email = jwtService.getUserEmail(httpServletRequest.getHeader("Authorization"));

        Optional<UserRebook> curReUser=userRebookDao.findById(userEmail); //이미 있는 정보
        Optional<Book> curBook=bookDao.findBookByIsbn(isbn);

        Optional<BookComment> curComment=bookCommentDao.findByBookAndUserRebook(curBook.get(),curReUser.get());

        if(curComment.isPresent()) {
            //현재 있는 정보에 다시 추가해줌
            curComment.get().setRating(rating);
            curComment.get().setReview(review);
            curComment.get().setUserRebook(curReUser.get());
            curComment.get().setBook(curBook.get());
            BookComment bookCommentSaved=bookCommentDao.save(curComment.get());

            return makeResponse("200",convertObjectToJson(bookCommentSaved),"review update success", HttpStatus.OK);

        }
        ResponseEntity<?>result=commentService.checkBlankWenCreateComment(curReUser,review,rating,curBook);
        if (result!=null){
            return result;
        }


        BookComment bookComment=commentService.buildComment(rating,review,curReUser.get(),curBook.get());

        BookComment savedComment=bookCommentDao.save(bookComment);

        return makeResponse("200",convertObjectToJson(savedComment),"success", HttpStatus.OK);
    }
    @DeleteMapping("/{commendId}")
    @ApiOperation(value="리뷰 삭제")
    public Object delete(@Valid @ApiParam(value=" commendID 값으로 리뷰 삭제 ",required = true)@PathVariable String commendId,String email ,HttpServletRequest httpServletRequest){

        Optional<BookComment> curComment=bookCommentDao.findById(Long.parseLong(commendId));
        Optional<UserRebook> curReUser=userRebookDao.findById(email);
        String userEmail=jwtService.getUserEmail(httpServletRequest.getHeader("Authorization"));
        if (curReUser.get().equals(userEmail)){
            return makeResponse("404", null, "user not found", HttpStatus.NOT_FOUND);
        }
        if (!curComment.isPresent()){
            return makeResponse("404",null,"review not found",HttpStatus.NOT_FOUND);
        }

        bookCommentDao.delete(curComment.get());
        return makeResponse("200",convertObjectToJson(curComment.get()),"success",HttpStatus.OK);


    }

    @GetMapping("/{email}")
    @ApiOperation(value="특정 유저가 특정 책에 쓴 코멘트 정보 검색")
    public Object search(@Valid @RequestBody @ApiParam(value="email로 특정 책 코멘트 정보 찾기",required =true) @PathVariable String email,String isbn){
        Optional<UserRebook> curReUser=userRebookDao.findById(email);
        Optional<Book> curBook=bookDao.findById(isbn);
        System.out.println(curReUser);
        System.out.println(curBook);
        Optional<BookComment> curComment=bookCommentDao.findByBookAndUserRebook(curBook.get(),curReUser.get());

        System.out.println(curComment.get());
        return makeResponse("200",convertObjectToJson(curComment.get()),"success",HttpStatus.OK);
    }





}
