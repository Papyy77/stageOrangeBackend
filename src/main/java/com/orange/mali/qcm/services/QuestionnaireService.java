package com.orange.mali.qcm.services;


import com.orange.mali.qcm.entities.Questionnaire;
import com.orange.mali.qcm.helpers.ResponseWrapper;
import com.orange.mali.qcm.repositories.QuestionnaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionnaireService {
  @Autowired
    private QuestionnaireRepo questionnaireRepo;
  public ResponseWrapper findAll(){
    return ResponseWrapper.of(questionnaireRepo.findAll());
  }
  public ResponseWrapper findById(Integer id){
    return ResponseWrapper.of(questionnaireRepo.findById(id));
  }

  public  ResponseWrapper save(Questionnaire questionnaire){
    return ResponseWrapper.of(questionnaireRepo.saveAndFlush(questionnaire));
  }

  public ResponseWrapper update(Integer id, Questionnaire questionnaire) {
    Optional<Questionnaire> res = questionnaireRepo.findById(id);
    if (!res.isPresent()) {
      return ResponseWrapper.error("Note not found");
    }
    questionnaire.setId(id);
    return ResponseWrapper.of(questionnaireRepo.saveAndFlush(questionnaire));
  }

}
