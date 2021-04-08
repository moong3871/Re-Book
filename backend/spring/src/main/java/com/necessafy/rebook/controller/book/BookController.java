package com.necessafy.rebook.controller.book;

import com.necessafy.rebook.Service.book.BookService;
import com.necessafy.rebook.Service.jwt.JwtService;
import com.necessafy.rebook.dao.DealDao;
import com.necessafy.rebook.dao.OldBookDao;
import com.necessafy.rebook.dao.account.UserRebookDao;
import com.necessafy.rebook.dao.book.BookCommentDao;
import com.necessafy.rebook.dao.book.BookDao;
import com.necessafy.rebook.dao.book.UserReadStatusDao;
import com.necessafy.rebook.model.CommonResult;
import com.necessafy.rebook.model.book.*;
import com.necessafy.rebook.model.market.Deal;
import com.necessafy.rebook.model.market.OldBook;
import com.necessafy.rebook.model.market.OldBookDto;
import com.necessafy.rebook.model.user.UserRebook;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.necessafy.rebook.utils.HttpUtils.makeResponse;
import static com.necessafy.rebook.utils.HttpUtils.convertObjectToJson;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/book")
public class BookController {
//    BookService

    @Autowired
    BookDao bookDao;

    @Autowired
    UserReadStatusDao userReadStatusDao;

    @Autowired
    BookCommentDao bookCommentDao;

    @Autowired
    UserRebookDao userRebookDao;

    @Autowired
    DealDao dealDao;

    @Autowired
    OldBookDao oldBookDao;

    @Autowired
    JwtService jwtService;

    @Autowired
    BookService bookService;

    // 책 상세정보 반환
    @GetMapping("/{isbn}")
    @ApiOperation(value = "전체 공개 게시물을 받아온다", response = CommonResult.class)
    public CommonResult retrieveBookDetail(@PathVariable String isbn, HttpServletRequest httpServletRequest){
        CommonResult commonResult = new CommonResult();

        String email = jwtService.getUserEmail(httpServletRequest.getHeader("Authorization"));
//        String email = "sbs@ssafy.com";
//        -----------전처리-------
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.printf(email);
        Optional<UserRebook> curReUser = userRebookDao.findByEmail(email);
        Optional<Book> curBook = bookDao.findById(isbn);

        // 1. for status
        // 2. for userEvaluation

        BookDetailRequest bookDetailRequest = new BookDetailRequest();

        if(curBook.isPresent() && curReUser.isPresent()) {
            Optional<UserReadStatus> userReadStatus = userReadStatusDao.findByUserRebookAndBook(curReUser.get(), curBook.get());
            Optional<BookComment> curComment = bookCommentDao.findByBookAndUserRebook(curBook.get(), curReUser.get());
            bookDetailRequest.setStatus(userReadStatus.isPresent()?userReadStatus.get().getStatus():0);
            bookDetailRequest.setUserEvaluation(curComment.isPresent()?curComment.get().getRating():0);
        }else {
            bookDetailRequest.setStatus(0);
            bookDetailRequest.setUserEvaluation(0);
        }
        // 3. for Market
        List<OldBook> bookDealList = oldBookDao.findByIsbn(isbn);
//        -----------------------
        List<BookComment> bookCommentList = new ArrayList<>();
        if(curBook.isPresent()){
            bookCommentList = bookCommentDao.findAllByBook(curBook.get());
        }
//        List<Book> recoBookList = new ArrayList<>();


        bookDetailRequest.setLat("36.3457153");
        bookDetailRequest.setLng("127.3021023");
        bookDetailRequest.setBookComment(bookCommentList);
//        bookDetailRequest.setRecoBooks(recoBookList);
        bookDetailRequest.setMarket(bookDealList);




//        Optional<Book> book = bookDao.findBookByIsbn(isbn);
//        if(!book.isPresent()) {
//            commonResult.status = false;
//            commonResult.data = "해당 isbn에 해당하는 책이 없습니다.";
//            commonResult.object = "";
//            return commonResult;
//        }else if(book.get().getBookSummary().equals("")){
//            book.get().setBookSummary("줄거리 정보가 없습니다.");
//        }
        commonResult.status = true;
        commonResult.data = "책 상세정보 반환에 성공하였습니다.";
        commonResult.object = bookDetailRequest;

        return commonResult;
//        return new CommonResult(true, "책 상세정보 반환에 성공하였습니다.", book.get());
    }

    // 책 상세정보 반환
    @GetMapping("/all")
    @ApiOperation(value = "전체 공개 게시물을 받아온다", response = CommonResult.class)
    public CommonResult retrieveAllBook(){
//        BookResponse bookResponse = ;
        CommonResult commonResult = new CommonResult();
        List<Book> bookList = bookDao.findAll();
        commonResult.status = true;
        commonResult.data = "책 상세정보 반환에 성공하였습니다.";
        commonResult.object = bookList;
        System.out.println(commonResult.data);
        System.out.println("hell"+commonResult.object + " 책 정보입니다!!");
        return commonResult;
//        return new CommonResult(true, "책 상세정보 반환에 성공하였습니다.", book.get());
    }


    @PutMapping("/{email}")
    @ApiOperation(value="해당 유저가 책을 읽은 상태를 등록")
    public Object createReadStatus(@RequestBody @ApiParam(value="상태 등록 시 필요한 정보 (status)",required = true)
                                   UserReadStatusRequest userReadStatusRequest, HttpServletRequest httpServletRequest){
// @ModelAttribute
//        System.out.print(userReadStatusRequest + "helloooooo");
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+status);
//        System.out.println(userReadStatusRequest.getEmail());
        // 여기까지 완료

//        String email=userReadStatusRequest.getUserRebook().getEmail().trim();
        Integer status = userReadStatusRequest.getStatus();
        String email=userReadStatusRequest.getEmail();
        String isbn=userReadStatusRequest.getBook().getIsbn().trim();
        Optional<UserRebook> curReUser=userRebookDao.findByEmail(email);

        Optional<Book> curBook=bookDao.findBookByIsbn(isbn);
        // 책을 저장
//        if(!curBook.isPresent()){
//            System.out.println("I saved this" + bookDao.save(userReadStatusRequest.getBook()));
//        }

        System.out.println("#######################################################");
        System.out.println(curReUser);
        //
        System.out.println(curBook);
        String emailToken = jwtService.getUserEmail(httpServletRequest.getHeader("Authorization"));

        ResponseEntity<?> result = bookService.checkBlankWenUserReadStatus(curReUser,status);

        if(result!=null){
            return result;
        }
        Optional<UserReadStatus> curStatus = userReadStatusDao.findByUserRebookAndBook(curReUser.get(),userReadStatusRequest.getBook());
        if(curStatus.isPresent()) {
            curStatus.get().setStatus(status);
//            UserReadStatus userReadStatus = userReadStatusDao.save(curStatus.get());
            return makeResponse("200", convertObjectToJson(curStatus.get()), "update status", HttpStatus.OK);
        }
        userReadStatusDao.save(bookService.buildStatus(status,curReUser.get(),userReadStatusRequest.getBook()));

//        UserReadStatus userReadStatus=new UserReadStatus();
//        userReadStatus.setStatus(status);
//        userReadStatus.setUserRebook(curReUser.get());
//        userReadStatus.setBook(userReadStatusRequest.getBook());
//        UserReadStatus savedReadStatus = userReadStatusDao.save(userReadStatus);

        return makeResponse("200",null,"success",HttpStatus.OK);
    }


    @GetMapping("/search/{email}")
    @ApiOperation(value="특정 유저의 상태(읽고 싶어요, 읽고있어요 읽었어요)따른 책 정보 반환")
    public Object searchReadStatus(@Valid @RequestBody @ApiParam(value="email별로 조회",required = true) @PathVariable String email, String isbn) {
        Optional<UserRebook> curReUser = userRebookDao.findByEmail(email);
        Optional<Book> curBook = bookDao.findById(isbn);


        Optional<UserReadStatus> userReadStatus = userReadStatusDao.findByUserRebookAndBook(curReUser.get(), curBook.get());

        //Optional로 쓰면 .get()
        return makeResponse("200", convertObjectToJson(userReadStatus.get()), "success", HttpStatus.OK);
    }
//    @GetMapping("{isbn}")
//    @ApiOperation(value="isbn에 관련된 모든 데이터를 가져온다.")
//    public Object searchAllList(@Valid @RequestBody @ApiParam(value = "isbn으로 모든 데이터 전환",required=true)
//                                @PathVariable String isbn){
//        Optional<Book> curBook=bookDao.findById(isbn);
//        Optional<UserRebook> curRe
//    }







}
