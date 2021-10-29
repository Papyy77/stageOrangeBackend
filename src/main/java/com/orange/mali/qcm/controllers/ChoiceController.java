package com.orange.mali.qcm.controllers;

import com.orange.mali.qcm.entities.Choice;
import com.orange.mali.qcm.helpers.ResponseHelper;
import com.orange.mali.qcm.services.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/choice")
public class ChoiceController {
    @Autowired
    private ChoiceService choiceService;
    @GetMapping("/")
    public ResponseEntity findAll(){
        return ResponseHelper.respondFromWrapper(choiceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        return ResponseHelper.respondFromWrapper(choiceService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody Choice choice){
        return ResponseHelper.respondFromWrapper(choiceService.save(choice));
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestParam Integer id, @RequestBody Choice choice){
        return ResponseHelper.respondFromWrapper(choiceService.update(id, choice));
    }

}
