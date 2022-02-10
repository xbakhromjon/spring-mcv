package uz.elmurodov.mapper;

import org.springframework.stereotype.Component;
import uz.elmurodov.dto.CreateProjectDto;
import uz.elmurodov.entity.Project;

import java.util.UUID;

@Component
public class ProjectMapper {
    public Project fromCreateDto(CreateProjectDto createProjectDto) {
        Project project = new Project();
        project.setName(createProjectDto.getName());
        project.setId(UUID.randomUUID());
        return project;
    }
}
