package com.orange.mali.qcm.controllers;

import com.orange.mali.qcm.helpers.ResponseHelper;
import com.orange.mali.qcm.profil.Note;
import com.orange.mali.qcm.profil.User;
import com.orange.mali.qcm.services.NoteService;
import com.orange.mali.qcm.services.UserService;
import com.orange.mali.qcm.wrappers.LoginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;
    @GetMapping("/")
    public ResponseEntity findAll(){
        return ResponseHelper.respondFromWrapper(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        return ResponseHelper.respondFromWrapper(userService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity save(@RequestBody User user){
        return ResponseHelper.respondFromWrapper(userService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity save(@RequestBody LoginWrapper user){
        return ResponseHelper.respondFromWrapper(userService.findByLogin(user));
    }

    @PostMapping("/note")
    public ResponseEntity save(@RequestBody Note note){
        return ResponseHelper.respondFromWrapper(noteService.save(note));
    }

    @PostMapping("/notes")
    public ResponseEntity save(@RequestBody String email){
        return ResponseHelper.respondFromWrapper(noteService.findByEmail(email));
    }

    @PutMapping("/")
    public ResponseEntity update(@RequestParam Integer id, @RequestBody User user){
        return ResponseHelper.respondFromWrapper(userService.update(id, user));
    }


}
