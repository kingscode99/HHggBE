package com.hhgg.hhggbe.user.controller;

import com.hhgg.hhggbe.user.dto.*;
import com.hhgg.hhggbe.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpStatus.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @PostMapping("/signup")  //@RequestBody
    public ResponseEntity<AuthMessage> signup(@RequestBody SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        AuthMessage authMessage = new AuthMessage("회원가입 성공");
        return new ResponseEntity<>(authMessage, OK);
    }

    @ResponseBody
    @PostMapping("/login") //@RequestBody
    public LoginErrorMessage login(@RequestBody LoginRequestDto loginRequestDto,
                                   HttpServletResponse response) {
        log.info("*******************"+loginRequestDto.getUsername());
        return userService.login(loginRequestDto, response);
    }

}