package ua.com.foxminded.task.domain.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@GroupTitleUnique(message = "Title is already exists!")
//TODO create unique test
@ApiModel(description = "Object with a audotory type information")
public class AuditoryTypeDto {

    @Min(value = 0, message = "Id must be more than zero!")
    @ApiModelProperty(notes = "The database generated auditory type id")
    private int id;

    @NotBlank(message = "Type name can`t be blank!")
    @Length(max = 45, message = "Maximum length is 45!")
    @ApiModelProperty(notes = "The unique type name. Max length is 45 character")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AuditoryTypeDto other = (AuditoryTypeDto) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AuditoryTypeDto [id=" + id 
             + ", type=" + type 
             + "]";
    }
    
}
