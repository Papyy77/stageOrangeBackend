package com.orange.mali.qcm.controllers;


import com.orange.mali.qcm.entities.Questionnaire;
import com.orange.mali.qcm.helpers.ResponseHelper;
import com.orange.mali.qcm.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;
    @GetMapping("/")
    public ResponseEntity findAll(){
        return ResponseHelper.respondFromWrapper(questionnaireService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        return ResponseHelper.respondFromWrapper(questionnaireService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody Questionnaire questionnaire){
        return ResponseHelper.respondFromWrapper(questionnaireService.save(questionnaire));
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestParam Integer id, @RequestBody Questionnaire questionnaire){
        return ResponseHelper.respondFromWrapper(questionnaireService.update(id, questionnaire));
    }

}
