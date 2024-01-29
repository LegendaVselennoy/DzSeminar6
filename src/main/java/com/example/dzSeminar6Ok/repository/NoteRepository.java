package com.example.dzSeminar6Ok.repository;

import com.example.dzSeminar6Ok.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
