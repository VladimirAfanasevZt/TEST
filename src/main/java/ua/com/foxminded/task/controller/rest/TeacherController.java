package ua.com.foxminded.task.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ua.com.foxminded.task.domain.dto.TeacherDto;
import ua.com.foxminded.task.service.TeacherService;

@RestController("teacherRestController")
@RequestMapping("/api")
@Api(description = "Teacher management System", produces = "application/json", consumes = "application/json")
public class TeacherController {

    private Logger logger;
    private TeacherService teacherService;

    @Autowired
    public TeacherController(Logger logger, TeacherService teacherService) {
        this.logger = logger;
        this.teacherService = teacherService;
    }

    @GetMapping(path = "/teachers", produces = "application/json")
    @ApiOperation(value = "View a list of available teachers")
    public List<TeacherDto> getEntities() {
        logger.debug("getEntities()");
        return teacherService.findAllDto();
    }

    @GetMapping(path = "/teachers/{id}", produces = "application/json")
    @ApiOperation(value = "View the teacher by id")
    public TeacherDto getEntityById(@PathVariable("id") int id) {
        logger.debug("getEntityById()");
        return teacherService.findByIdDto(id);
    }

    @PostMapping(path = "/teachers", produces = "application/json")
    @ApiOperation(value = "Create (if id=0) or update the teacher")
    public TeacherDto saveEntity(@Valid @RequestBody TeacherDto teacherDto) {
        logger.debug("saveEntity()");
        if (teacherDto.getId() != 0) {
            teacherDto = teacherService.update(teacherDto);
        } else {
            teacherDto = teacherService.create(teacherDto);
        }
        return teacherDto;
    }

}
