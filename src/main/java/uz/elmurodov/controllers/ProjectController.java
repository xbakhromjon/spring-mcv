package uz.elmurodov.controllers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.elmurodov.dto.CreateProjectDto;
import uz.elmurodov.dto.UpdateProjectDto;
import uz.elmurodov.entity.Project;
import uz.elmurodov.mapper.ProjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/project/*")
public class ProjectController {
    private final ProjectMapper projectMapper;
    private static List<Project> projects = new ArrayList<>();

    static {
        projects.add(new Project("Project1"));
        projects.add(new Project("Project2"));
    }

    public ProjectController(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @RequestMapping("projects")
    private String projectList(Model model) {
        model.addAttribute("projects", projects);
        return "/project/projects";
    }

    @RequestMapping("delete/{id}")
    private String delete(@PathVariable UUID id) {
        projects.removeIf(project -> project.getId().equals(id));
        return "redirect:/project/projects";
    }

    @GetMapping("details/{id}")
    private String details(@PathVariable UUID id, Model model) {
        for (Project project : projects) {
            if (project.getId().equals(id)) {
                model.addAttribute("project", project);
                break;
            }
        }
        return "/project/details";
    }

    @RequestMapping("update/{id}")
    private String update(@PathVariable UUID id) {
        return "/project/create";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    private String update(@PathVariable UUID id, @ModelAttribute UpdateProjectDto updateProjectDto) {
        for (Project project : projects) {
            if (project.getId().equals(id)) {
                project.setName(updateProjectDto.getName());
            }
        }
        return "redirect:/project/projects";
    }
    @RequestMapping("create")
    private String create() {
        return "/project/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    private String create(@ModelAttribute CreateProjectDto createProjectDto) {
        projects.add(projectMapper.fromCreateDto(createProjectDto));
        return "redirect:/project/projects";
    }

}
