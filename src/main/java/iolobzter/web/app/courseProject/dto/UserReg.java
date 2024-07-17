package iolobzter.web.app.courseProject.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReg {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;
}
