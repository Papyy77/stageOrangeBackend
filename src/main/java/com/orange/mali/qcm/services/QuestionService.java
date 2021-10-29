package com.orange.mali.qcm.services;


import com.orange.mali.qcm.entities.Question;
import com.orange.mali.qcm.helpers.ResponseWrapper;
import com.orange.mali.qcm.repositories.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    public ResponseWrapper findAll(){
        return ResponseWrapper.of(questionRepo.findAll());
    }
   public ResponseWrapper findById(Integer id){
        return ResponseWrapper.of(questionRepo.findById(id));
   }

   public ResponseWrapper save(Question question){
        return ResponseWrapper.of(questionRepo.saveAndFlush(question));
   }

   public ResponseWrapper update(Integer id, Question question){
        Optional<Question> res = questionRepo.findById(id);
        if(!res.isPresent()) {
            return ResponseWrapper.error("Question not found");
        }
        return ResponseWrapper.of(questionRepo.saveAndFlush(question));
   }


}

