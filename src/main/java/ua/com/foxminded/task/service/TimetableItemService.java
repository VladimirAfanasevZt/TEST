package ua.com.foxminded.task.service;

import java.time.LocalDate;

import ua.com.foxminded.task.domain.TimetableItem;
import ua.com.foxminded.task.domain.dto.TimetableItemDto;

public interface TimetableItemService extends ModelService<TimetableItemDto> {

    public TimetableItem findByAuditoryIdAndLectureIdAndDate(Integer auditoryId, Integer lectureId, LocalDate date);

    public TimetableItem findByTeacherIdAndLectureIdAndDate(Integer teacherId, Integer lectureId, LocalDate date);
}
