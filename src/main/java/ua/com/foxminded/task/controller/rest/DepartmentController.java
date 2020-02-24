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
import ua.com.foxminded.task.domain.dto.DepartmentDto;
import ua.com.foxminded.task.service.DepartmentService;

@RestController("departmentRestController")
@RequestMapping("/api")
@Api(description = "Department management System", produces = "application/json", consumes = "application/json")
public class DepartmentController {

    private Logger logger;
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(Logger logger, DepartmentService departmentService) {
        this.logger = logger;
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/departments", produces = "application/json")
    @ApiOperation(value = "View a list of available departments")
    public List<DepartmentDto> getEntities() {
        logger.debug("getEntities()");
        return departmentService.findAllDto();
    }

    @GetMapping(path = "/departments/{id}", produces = "application/json")
    @ApiOperation(value = "View the department by id")
    public DepartmentDto getEntityById(@PathVariable("id") int id) {
        logger.debug("getEntityById()");
        return departmentService.findByIdDto(id);
    }

    @PostMapping(path = "/departments", produces = "application/json")
    @ApiOperation(value = "Create (if id=0) or update the department")
    public DepartmentDto saveEntity(@Valid @RequestBody DepartmentDto departmentDto) {
        logger.debug("saveEntity()");
        if (departmentDto.getId() != 0) {
            departmentDto = departmentService.update(departmentDto);
        } else {
            departmentDto = departmentService.create(departmentDto);
        }
        return departmentDto;
    }

}
