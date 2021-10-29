package com.orange.mali.qcm.services;

import com.orange.mali.qcm.entities.Choice;
import com.orange.mali.qcm.helpers.ResponseWrapper;
import com.orange.mali.qcm.repositories.ChoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChoiceService {
    @Autowired
    private ChoiceRepo choiceRepo;
    public ResponseWrapper findAll(){
        return ResponseWrapper.of(choiceRepo.findAll());
    }
    public ResponseWrapper findById(Integer id){
        return ResponseWrapper.of(choiceRepo.findById(id));
    }

    public  ResponseWrapper save(Choice choice){
        return ResponseWrapper.of(choiceRepo.saveAndFlush(choice));
    }

    public ResponseWrapper update(Integer id, Choice choice) {
        Optional<Choice> res = choiceRepo.findById(id);
        if (!res.isPresent()) {
            return ResponseWrapper.error("Choice not found");
        }
        choice.setId(id);
        return ResponseWrapper.of(choiceRepo.saveAndFlush(choice));
    }

}
