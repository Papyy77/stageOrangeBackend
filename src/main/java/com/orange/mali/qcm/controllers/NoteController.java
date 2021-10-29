package com.orange.mali.qcm.controllers;

import com.orange.mali.qcm.helpers.ResponseHelper;
import com.orange.mali.qcm.profil.Note;
import com.orange.mali.qcm.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/note")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @GetMapping("/")
    public ResponseEntity findAll(){
        return ResponseHelper.respondFromWrapper(noteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        return ResponseHelper.respondFromWrapper(noteService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody Note note){
        return ResponseHelper.respondFromWrapper(noteService.save(note));
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestParam Integer id, @RequestBody Note note){
        return ResponseHelper.respondFromWrapper(noteService.update(id, note));
    }

}
