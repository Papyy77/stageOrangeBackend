package com.orange.mali.qcm.repositories;

import com.orange.mali.qcm.profil.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note,Integer> {

    List<Note> findByEmail(String email);
}
