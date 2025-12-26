package com.college.college.service;

import com.college.college.controller.StudentController;
import com.college.college.dto.CreateProfessorDTO;
import com.college.college.entity.Professor;
import com.college.college.entity.Subject;
import com.college.college.repository.ProfessorRepository;
import com.college.college.repository.StudentRepo;
import com.college.college.repository.SubjectRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final StudentRepo studentRepo;
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;


    @Transactional
    public Professor addProfesor(CreateProfessorDTO createProfessorDTO){
        Professor professor = professorRepository
                .findByTitle(createProfessorDTO.getTitle())
                .orElse(new Professor());

        professor.setTitle(createProfessorDTO.getTitle());
        professorRepository.save(professor);

        for (String subjectTitle : createProfessorDTO.getSubjects()) {
            Subject sub=subjectRepository.findByTitle(subjectTitle).orElse(new Subject());
            sub.setTitle(subjectTitle);
            sub.setProfessor(professor);
            subjectRepository.save(sub);
        }
        return professor;
    }





}
