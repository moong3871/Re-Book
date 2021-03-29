package com.necessafy.rebook.controller;



import javax.validation.Valid;


import com.necessafy.rebook.Service.account.AccountService;
import com.necessafy.rebook.Service.jwt.JwtService;
import com.necessafy.rebook.dao.UserRebookDao;
import com.necessafy.rebook.model.BasicResponse;
import com.necessafy.rebook.model.user.*;

import com.necessafy.rebook.utils.SHA256Util;
import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import static com.necessafy.rebook.utils.HttpUtils.convertObjectToJson;
import static com.necessafy.rebook.utils.HttpUtils.makeResponse;


import io.swagger.annotations.ApiOperation;

import java.util.Optional;


//@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserRebookDao userRebookDao;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/signup")
    @ApiOperation(value="회원가입",notes = "이메일, 닉네임, 비밀번호를 입력합니다.")
    public Object signup(@Valid @RequestBody @ApiParam(value = "회원가입시 필요한 정보 (이메일, 별명, 비밀번호)"
            ,required=true)SignupRequest request){
        String email = request.getEmail().trim();
        String nickname = request.getNickname().trim();

        String salt= SHA256Util.generateSalt();
        String password =SHA256Util.getEncrypt(request.getPassword().trim(),salt);
        Object response = accountService.overlabAndBlankCheckWhenSignUp(email,nickname,password);

        if(response!=null){
            return response;
        }

        UserRebook user= accountService.buildUser(email,password,nickname,salt);

        UserRebook savedUser=userRebookDao.save(user);

        return makeResponse("200",convertObjectToJson(savedUser),"success", HttpStatus.OK);
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인",notes = "아이디와 비밀번호로 로그인을 합니다.")
    public Object login(
            @RequestBody @ApiParam(value = "로그인 시 필요한 회원정보 (아이디,비밀번호)",required = true)
            AuthenticationRequest request){

        String email =request.getEmail().trim();
        String beforePassword=request.getPassword().trim();
        String salt=userRebookDao.findByEmail(email).get().getSalt();

        String password=SHA256Util.getEncrypt(beforePassword,salt);

        Optional<UserRebook> curReUser=userRebookDao.findUserRebookByEmailAndPassword(email,password);


        //로그인 했을 떄 유저 정보 보내주기
        if (curReUser.isPresent()){

            String token =jwtService.create("email",curReUser.get().getEmail(),"Authorization");

            AuthenticationResponse response=new AuthenticationResponse(curReUser.get(),token);
            return makeResponse("200",convertObjectToJson(response),"success",HttpStatus.OK);

        }else {
            return makeResponse("400",null,"fail login",HttpStatus.BAD_REQUEST);
        }
    }


}
