package uz.elmurodov.dto;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateDto {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
}
