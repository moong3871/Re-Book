//package com.necessafy.rebook.controller;
//
////import com.necessafy.rebook.Service.BookRecommendService;
////import com.necessafy.rebook.Service.ResponseService;
//import com.necessafy.rebook.model.CommonResult;
//import com.necessafy.rebook.model.user.UserUpdate;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class AccountController {
////    private final ResponseService responseService;
////    private final AccountService accountService;
////    스프링 시큐리티에서 지원
////    @GetMapping("/user/login")
////    public CommonResult login(){
////
////    }
//    @PostMapping("/user/signup")
//    public CommonResult signUp(){
//        return new CommonResult();
//    }
//
//    // 회원 정보 수정
//    @PutMapping("/user")
//    public void updateUser(@RequestBody UserUpdate userUpdate){
//    }
//
//    // 회원 탈퇴
//    @DeleteMapping("/user/{userId}")
//    public void deleteUser(@PathVariable int userId){
//
//    }
//
//    // 유저의 좋아요 정보 반환
//    @GetMapping("/user/{userId}")
//    @ApiOperation(value = "전체 공개 게시물을 받아온다", response = CommonResult.class)
//    public CommonResult retrieveUser(){
//        return new CommonResult();
//    }
//}
//
//
//
////package com.web.curation.controller.account;
////
////import java.util.Optional;
////
////import javax.validation.Valid;
////
////import com.web.curation.dao.user.UserDao;
////import com.web.curation.model.BasicResponse;
////import com.web.curation.model.user.SignupRequest;
////import com.web.curation.model.user.User;
////
////import org.springframework.web.bind.annotation.RestController;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.CrossOrigin;
////import org.springframework.beans.factory.annotation.Autowired;
////
////import io.swagger.annotations.ApiResponse;
////import io.swagger.annotations.ApiResponses;
////import io.swagger.annotations.ApiOperation;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////
////@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized", response = BasicResponse.class),
////        @ApiResponse(code = 403, message = "Forbidden", response = BasicResponse.class),
////        @ApiResponse(code = 404, message = "Not Found", response = BasicResponse.class),
////        @ApiResponse(code = 500, message = "Failure", response = BasicResponse.class) })
////
////@CrossOrigin(origins = { "http://localhost:3000" })
////@RestController
////public class AccountController {
////
////    @Autowired
////    UserDao userDao;
////
////    @GetMapping("/account/login")
////    @ApiOperation(value = "로그인")
////    public Object login(@RequestParam(required = true) final String email,
////            @RequestParam(required = true) final String password) {
////
////        Optional<User> userOpt = userDao.findUserByEmailAndPassword(email, password);
////
////        ResponseEntity response = null;
////
////        if (userOpt.isPresent()) {
////            final BasicResponse result = new BasicResponse();
////            result.status = true;
////            result.data = "success";
////            response = new ResponseEntity<>(result, HttpStatus.OK);
////        } else {
////            response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
////        }
////
////        return response;
////    }
////
////    @PostMapping("/account/signup")
////    @ApiOperation(value = "가입하기")
////
////    public Object signup(@Valid @RequestBody SignupRequest request) {
////        // 이메일, 닉네임 중복처리 필수
////        // 회원가입단을 생성해 보세요.
////
////        final BasicResponse result = new BasicResponse();
////        result.status = true;
////        result.data = "success";
////
////        return new ResponseEntity<>(result, HttpStatus.OK);
////    }
////
////}