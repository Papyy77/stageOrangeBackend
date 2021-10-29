package com.orange.mali.qcm.services;

import com.orange.mali.qcm.helpers.ResponseWrapper;
import com.orange.mali.qcm.profil.Note;
import com.orange.mali.qcm.repositories.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;
    public ResponseWrapper findAll(){
        return ResponseWrapper.of(noteRepo.findAll());
    }

    public ResponseWrapper findByEmail(String email){
        return ResponseWrapper.of(noteRepo.findByEmail(email));
    }


    public ResponseWrapper findById(Integer id){
        return ResponseWrapper.of(noteRepo.findById(id));
    }

    public  ResponseWrapper save(Note note){
        System.out.println("note:::::" + note);
        note.setDate(new Date());
        return ResponseWrapper.of(noteRepo.saveAndFlush(note));
    }

    public ResponseWrapper update(Integer id, Note note) {
        Optional<Note> res = noteRepo.findById(id);
        if (!res.isPresent()) {
            return ResponseWrapper.error("Note not found");
        }
        note.setId(id);
        return ResponseWrapper.of(noteRepo.saveAndFlush(note));
    }
}
