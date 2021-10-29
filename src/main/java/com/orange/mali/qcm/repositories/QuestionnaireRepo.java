package com.orange.mali.qcm.repositories;

import com.orange.mali.qcm.entities.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireRepo extends JpaRepository<Questionnaire,Integer> {
}
