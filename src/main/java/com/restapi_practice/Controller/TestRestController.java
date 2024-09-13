package com.restapi_practice.Controller;

import com.restapi_practice.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class TestRestController {


    /**
     *
     * 회원 전체 목록: GET: /users
     * 회원 등록: POST /users
     * 회원 상세 조회: GET: /users/{userId}
     * 회원 수정: PUT /users/{userId}
     * 회원 삭제: DELETE /users/{userId}
     */


    @GetMapping ("/test/users")
    public String users () {
        return "유저 전체 목록 조회";
    }

//     객체 없이 테스트
//        @PostMapping("/test/users")
//    public String userAdd () {
//        return "유저 저장";
//    }



//    @GetMapping("/test/users/{uesrId}")
//    public String getUser (@PathVariable String userId) {
//        return userId + "유저 상세 조회";
//    }

    @PutMapping("/test/users/{userId}")
    public String updateUser (@PathVariable String userId) {
        return userId + "유저 수정";
    }

    @DeleteMapping("/test/users/{userId}")
    public String deleteUser (@PathVariable String userId) {
        return userId + "유저 삭제";
    }


    @GetMapping("/test/users/{userId}")
    public String searchUser (@PathVariable String userId, @RequestParam String search) {
        log.info("search={}", search);
        log.info("userId={}", userId);
        return search + "유저 검색";
    }

    // dto에 유저 정보 넣기
//    @PostMapping("/test/users")
//    public String addUser (@RequestBody TestDto testDto) {
//        log.info("testDto={}", testDto);
//        return "유저 객체에 저장";
//    }



    // HttpEntity 사용해서해보기
//    @PostMapping("/test/users")
//    public String addUser (HttpEntity<TestDto> testDto) {
//        TestDto data = testDto.getBody();
//        log.info("testDto={}", data);
//        return "유저 객체에 저장";
//    }

    // 반환을 Stirng -> 객체로
        @PostMapping("/test/users")
    public TestDto addUser (@RequestBody TestDto testDto) {
        log.info("testDto={}", testDto);
        return testDto;
    }
}
