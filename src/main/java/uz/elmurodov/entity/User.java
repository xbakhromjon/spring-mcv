package uz.elmurodov.entity;

import lombok.*;

import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String username;
    private String password;
    private UUID id = UUID.randomUUID();
    private String email;
    private String phoneNumber;
}
