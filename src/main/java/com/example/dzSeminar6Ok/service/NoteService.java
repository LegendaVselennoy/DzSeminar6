package com.example.dzSeminar6Ok.service;

import com.example.dzSeminar6Ok.model.Note;
import com.example.dzSeminar6Ok.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepos;

    public Note addNote(Note note) {
        return noteRepos.save(note);
    }

    public List<Note> findAllNotes() {
        return noteRepos.findAll();
    }

    public Optional<Note> getNodeById(Long id) {
        return noteRepos.findById(id);
    }

    public Note updateNote(Long id,Note note) {
       Optional<Note> currentNote=noteRepos.findById(id);
       if (currentNote.isPresent()){
           Note changeNote=currentNote.get();
           changeNote.setTitle(note.getTitle());
           changeNote.setContent(note.getContent());
           changeNote.setLocalDateTime(note.getLocalDateTime());
       }
       return noteRepos.save(note);

    }

    public void deleteNote(Long id) {
        noteRepos.deleteById(id);
    }
}
