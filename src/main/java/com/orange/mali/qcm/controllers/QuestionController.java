package com.orange.mali.qcm.controllers;

import com.orange.mali.qcm.entities.Question;
import com.orange.mali.qcm.helpers.ResponseHelper;
import com.orange.mali.qcm.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/")
    public ResponseEntity findAll(){
        return ResponseHelper.respondFromWrapper(questionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        return ResponseHelper.respondFromWrapper(questionService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody Question question){
        return ResponseHelper.respondFromWrapper(questionService.save(question));
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestParam Integer id, @RequestBody Question question){
        return ResponseHelper.respondFromWrapper(questionService.update(id, question));
    }

}
