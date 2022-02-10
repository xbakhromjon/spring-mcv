package uz.elmurodov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.dto.LoginDto;
import uz.elmurodov.dto.UserCreateDto;
import uz.elmurodov.entity.User;
import uz.elmurodov.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/auth/*")
public class AuthUserController {
    private final UserMapper userMapper;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(User.builder()
                .username("Bakhromjon")
                .password("password123")
                .email("xbakhromjon@gmail.com")
                .phoneNumber("+998945520609")
                .build());
        users.add(User.builder()
                .username("Bakhromjon1")
                .password("password123")
                .email("xbakhromjon1@gmail.com")
                .phoneNumber("+998945520609")
                .build());
    }

    public AuthUserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("login")
    private String loginPage() {
        return "auth/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    private String login(@ModelAttribute LoginDto loginDto) {
        for (User user : users) {
            if (user.getUsername().equals(loginDto.getUsername()) && user.getPassword().equals(loginDto.getPassword())) {
                return "redirect:/main";
            }
        }
        return "redirect:/home";
    }

    @RequestMapping("signup")
    private String signUp() {
        return "auth/signup";
    }
    @RequestMapping(value = "signup", method = RequestMethod.POST)
    private String signUp(@ModelAttribute UserCreateDto userCreateDto) {
        User user = userMapper.fromUserCreateDto(userCreateDto);
        users.add(user);
        return "home";
    }
}
