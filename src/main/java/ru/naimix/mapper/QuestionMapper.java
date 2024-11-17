package ru.naimix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.naimix.domain.entity.Question;
import ru.naimix.model.QuestionResponse;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionMapper {
    QuestionResponse toQuestionResponse(Question question);
    List<QuestionResponse> toQuestionResponseList(List<Question> questions);
}
