package iolobzter.web.app.courseProject.service;


import iolobzter.web.app.courseProject.dto.UserAuth;
import iolobzter.web.app.courseProject.dto.UserReg;
import iolobzter.web.app.courseProject.entity.User;
import iolobzter.web.app.courseProject.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;
    private  final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    public String authenticate(UserAuth authDetails) {
            User user = userDetailsService.loadUserByUsername(authDetails.getEmail())
    }

    public User register(UserReg regDetails) {
        User user = User.builder()
                .email(regDetails.getEmail())
                .firstName(regDetails.getFirstName())
                .lastName(regDetails.getLastName())
                .age(regDetails.getAge())
                .password(passwordEncoder.encode(regDetails.getPassword()))
                .build();

        return userRepository.save(user);
    }
}
