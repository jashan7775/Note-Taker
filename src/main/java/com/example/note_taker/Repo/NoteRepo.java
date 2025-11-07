package com.example.note_taker.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.note_taker.entity.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {

	Object findByUsername(String username);

}
