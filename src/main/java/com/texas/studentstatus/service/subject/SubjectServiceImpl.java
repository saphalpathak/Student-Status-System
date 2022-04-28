package com.texas.studentstatus.service.subject;

import com.texas.studentstatus.dto.SubjectDto;
import com.texas.studentstatus.entity.Subject;
import com.texas.studentstatus.exceptions.ResourceNotFoundException;
import com.texas.studentstatus.repo.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepo subjectRepo;

    public SubjectServiceImpl(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    @Override
    public List<SubjectDto> findAllSubject() {
        return SubjectDto.toDtos(subjectRepo.findAll());
    }

    @Override
    public SubjectDto saveSubject(SubjectDto subjectDto) {
        Subject subject = new Subject();
        if (subjectDto.getId() != null && subjectDto.getId() != 0) {
            subject = subjectRepo.findById(subjectDto.getId()).orElseThrow(
                    ()-> new ResourceNotFoundException("Subject","id",subjectDto.getId())
            );
        }
        subject.setName(subjectDto.getName());
        subject.setSemester(subjectDto.getSemester());
        subject.setTeacher(subjectDto.getTeacher());
        return new SubjectDto(subjectRepo.save(subject));
    }

    @Override
    public SubjectDto findSubjectById(Integer id) {
        Subject subject = subjectRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subject", "id", id)
        );
        return new SubjectDto(subject);
    }

    @Override
    public void deleteSubjectById(Integer id) {
        subjectRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subject", "id", id)
        );
        subjectRepo.deleteById(id);

    }
}
