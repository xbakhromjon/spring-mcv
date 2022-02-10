package uz.elmurodov.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class Project {
    private String name;
    private UUID id;
    private LocalDateTime createdAt = LocalDateTime.now();
    public Project(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }
}
