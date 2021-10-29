package com.orange.mali.qcm.repositories;

import com.orange.mali.qcm.entities.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepo extends JpaRepository<Choice, Integer> {
}
