package uz.elmurodov.mapper;

import org.springframework.stereotype.Component;
import uz.elmurodov.dto.UserCreateDto;
import uz.elmurodov.entity.User;

@Component
public class UserMapper {
    public User fromUserCreateDto(UserCreateDto userCreateDto) {
        User user = User.builder().username(userCreateDto.getUsername())
                .phoneNumber(userCreateDto.getPhoneNumber())
                .email(userCreateDto.getEmail())
                .password(userCreateDto.getPassword()).build();
        return user;
    }
}
