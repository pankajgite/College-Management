package com.college.college.service;

import com.college.college.dto.CreateStudent;
import com.college.college.entity.AddmissionRecord;
import com.college.college.entity.Professor;
import com.college.college.entity.Student;
import com.college.college.entity.Subject;
import com.college.college.repository.AddmissionRecordRepository;
import com.college.college.repository.StudentRepo;
import com.college.college.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final AddmissionRecordRepository addmissionRecordRepository;
    private final SubjectRepository subjectRepository;

    @Transactional
    public Student addStudent(CreateStudent createStudent){
        Student student =new Student();
        student.setName(createStudent.getName());
        List<Subject> subjects = new ArrayList<>();
        List<Professor> professors = new ArrayList<>();
        for(String sub: createStudent.getSubjects()){
            Subject subject= subjectRepository.findByTitle(sub).orElseThrow();
            subjects.add(subject);
            professors.add(subject.getProfessor());

        }
        student.setSubjects(subjects);
        student.setProfessors(professors);
        studentRepo.save(student);

        AddmissionRecord addmissionRecord =new AddmissionRecord();
        addmissionRecord.setFees(createStudent.getFees());
        addmissionRecord.setStudent(student);
        addmissionRecordRepository.save(addmissionRecord);
        return student;
    }
    
    @Transactional
    public List<Student> getStudent(){
        return studentRepo.findAll();
    }


}
