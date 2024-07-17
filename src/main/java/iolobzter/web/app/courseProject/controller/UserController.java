package iolobzter.web.app.courseProject.controller;

import iolobzter.web.app.courseProject.dto.UserAuth;
import iolobzter.web.app.courseProject.dto.UserReg;
import iolobzter.web.app.courseProject.entity.User;
import iolobzter.web.app.courseProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    public  ResponseEntity<String> authenticate(@RequestBody  UserAuth authDetails){
        return ResponseEntity.ok(userService.authenticate(authDetails));
    }

    public ResponseEntity<User> register(@RequestBody UserReg regDetails){
        return ResponseEntity.ok(userService.register(regDetails));
    }


}
