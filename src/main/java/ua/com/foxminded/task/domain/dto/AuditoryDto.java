package ua.com.foxminded.task.domain.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ua.com.foxminded.task.validation.annotation.PropertyValueUnique;

@PropertyValueUnique(message = "Auditory number is already exists!", nameProperty = "auditoryNumber")
@ApiModel(description = "Object with a auditory information")
public class AuditoryDto {

    @Min(value = 0, message = "Id must be more than zero!")
    @ApiModelProperty(notes = "The database generated auditory id")
    private int id;

    @NotBlank(message = "Title of auditory can`t be blank!")
    @Length(max = 20, message = "Maximum length is 20!")
    @ApiModelProperty(notes = "The unique name of auditory. Max length is 20 character")
    private String auditoryNumber;

    @Length(max = 45, message = "Maximum length of auditory type title group is 45!")
    @ApiModelProperty(notes = "The auditory type title. Max length is 45 character")
    private String auditoryTypeTitle;

    @ApiModelProperty(notes = "The unique number of students group")
    private int idAuditoryType;
    
    @NotNull(message = "Year of entry can`t be blank or not numeric!")
    @Pattern(regexp = "^\\d+$", message = "Max capacity must be numeric")
    @ApiModelProperty(notes = "The max capacity students in auditory. Value must be numeric.")
    private Integer maxCapacity;
    
    @Length(max = 200, message = "Maximum length of auditory description is 200!")
    @ApiModelProperty(notes = "The descrioption of auditory. Max length is 200 character")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuditoryNumber() {
        return auditoryNumber;
    }

    public void setAuditoryNumber(String auditoryNumber) {
        this.auditoryNumber = auditoryNumber;
    }

    public String getAuditoryTypeTitle() {
        return auditoryTypeTitle;
    }

    public void setAuditoryTypeTitle(String auditoryTypeTitle) {
        this.auditoryTypeTitle = auditoryTypeTitle;
    }

    public int getIdAuditoryType() {
        return idAuditoryType;
    }

    public void setIdAuditoryType(int idAuditoryType) {
        this.idAuditoryType = idAuditoryType;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((auditoryNumber == null) ? 0 : auditoryNumber.hashCode());
        result = prime * result + ((auditoryTypeTitle == null) ? 0 : auditoryTypeTitle.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + idAuditoryType;
        result = prime * result + ((maxCapacity == null) ? 0 : maxCapacity.hashCode());
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
        AuditoryDto other = (AuditoryDto) obj;
        if (auditoryNumber == null) {
            if (other.auditoryNumber != null)
                return false;
        } else if (!auditoryNumber.equals(other.auditoryNumber))
            return false;
        if (auditoryTypeTitle == null) {
            if (other.auditoryTypeTitle != null)
                return false;
        } else if (!auditoryTypeTitle.equals(other.auditoryTypeTitle))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (idAuditoryType != other.idAuditoryType)
            return false;
        if (maxCapacity == null) {
            if (other.maxCapacity != null)
                return false;
        } else if (!maxCapacity.equals(other.maxCapacity))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AuditoryDto [id=" + id 
             + ", auditoryNumber=" + auditoryNumber 
             + ", auditoryTypeTitle=" + auditoryTypeTitle 
             + ", idAuditoryType=" + idAuditoryType 
             + ", maxCapacity=" + maxCapacity
             + ", description=" + description 
             + "]";
    }

}
