package com.college.college.repository;

import com.college.college.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {


    Optional<Professor> findByTitle(String title);
}