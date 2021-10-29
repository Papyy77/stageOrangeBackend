package com.orange.mali.qcm.repositories;

import com.orange.mali.qcm.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Integer> {
}
