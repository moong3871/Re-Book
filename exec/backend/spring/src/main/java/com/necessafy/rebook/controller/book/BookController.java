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

import javax.jws.soap.SOAPBinding;
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
    @PostMapping("/{isbn}")
    @ApiOperation(value = "전체 공개 게시물을 받아온다", response = CommonResult.class)
    public CommonResult retrieveBookDetail(@PathVariable String isbn, HttpServletRequest httpServletRequest){
        CommonResult commonResult = new CommonResult();

        String email = jwtService.getUserEmail(httpServletRequest.getHeader("Authorization"));
//        String email = "sbs@ssafy.com";
//        -----------전처리-------
        Optional<UserRebook> curReUser = userRebookDao.findById(email);
        Optional<Book> curBook = bookDao.findById(isbn);
        // 1. for status
        Optional<UserReadStatus> userReadStatus = userReadStatusDao.findByUserRebookAndBook(curReUser.get(), curBook.get());
        // 2. for userEvaluation
        Optional<BookComment> curComment=bookCommentDao.findByBookAndUserRebook(curBook.get(),curReUser.get());
        // 3. for Market
        List<OldBook> bookDealList = oldBookDao.findByIsbn(isbn);
//        -----------------------
        BookDetailRequest bookDetailRequest = new BookDetailRequest();
        List<BookComment> bookCommentList = new ArrayList<>();
        List<Book> recoBookList = new ArrayList<>();


        bookDetailRequest.setLat("36.3457153");
        bookDetailRequest.setLng("127.3021023");
        bookDetailRequest.setStatus(userReadStatus.isPresent()?userReadStatus.get().getStatus():0);
        bookDetailRequest.setUserEvaluation(curComment.isPresent()?curComment.get().getRating():0);
        bookDetailRequest.setBookComment(bookCommentList);
        bookDetailRequest.setRecoBooks(recoBookList);
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


    @Transactional
    @PutMapping("/{email}")
    @ApiOperation(value="해당 유저가 책을 읽은 상태를 등록")
    public Object createReadStatus(@RequestBody @ApiParam(value="상태 등록 시 필요한 정보 (status)",required = true)
                                   UserReadStatusRequest userReadStatusRequest, HttpServletRequest httpServletRequest){
// @ModelAttribute
        System.out.print(userReadStatusRequest + "helloooooo");
        Integer status=userReadStatusRequest.getStatus();
        System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+status);
        System.out.print(userReadStatusRequest.getEmail());

//        String email=userReadStatusRequest.getUserRebook().getEmail().trim();
        String email=userReadStatusRequest.getEmail();
        String isbn=userReadStatusRequest.getBook().getIsbn().trim();
        Optional<UserRebook>curReUser=userRebookDao.findById(email);

        Optional<Book>curBook=bookDao.findBookByIsbn(isbn);
        if(!curBook.isPresent()){
            bookDao.save(userReadStatusRequest.getBook());
        }

        System.out.println("");
        System.out.println("#######################################################");
        System.out.println(curReUser);
        System.out.println(curBook);
        String emailToken = jwtService.getUserEmail(httpServletRequest.getHeader("Authorization"));

        ResponseEntity<?>result=bookService.checkBlankWenUserReadStatus(curReUser,status);

        if(result!=null){
            return result;
        }
        Optional<UserReadStatus> curStatus=userReadStatusDao.findByUserRebookAndBook(curReUser.get(),userReadStatusRequest.getBook());
        if(curStatus.isPresent()) {
            curStatus.get().setStatus(status);
//            UserReadStatus userReadStatus = userReadStatusDao.save(curStatus.get());
            return makeResponse("200", convertObjectToJson(curStatus.get()), "update status", HttpStatus.OK);
        }
        UserReadStatus userReadStatus=bookService.buildStatus(status,curReUser.get(),userReadStatusRequest.getBook());
        UserReadStatus savedStatus=userReadStatusDao.save(userReadStatus);

        return makeResponse("200",convertObjectToJson(savedStatus),"success",HttpStatus.OK);

    }


    @GetMapping("/search/{email}")
    @ApiOperation(value="특정 유저의 상태(읽고 싶어요, 읽고있어요 읽었어요)따른 책 정보 반환")
    public Object searchReadStatus(@Valid @RequestBody @ApiParam(value="email별로 조회",required = true) @PathVariable String email, String isbn) {
        Optional<UserRebook> curReUser = userRebookDao.findById(email);
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
