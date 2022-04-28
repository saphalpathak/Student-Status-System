package com.texas.studentstatus.service.subject;
import com.texas.studentstatus.dto.SubjectDto;

import java.util.List;

public interface SubjectService {

    List<SubjectDto> findAllSubject();
    SubjectDto saveSubject(SubjectDto subjectDto);
    SubjectDto findSubjectById(Integer id);
    void deleteSubjectById(Integer id);

}
