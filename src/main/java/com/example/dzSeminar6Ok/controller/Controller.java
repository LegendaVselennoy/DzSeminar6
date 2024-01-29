package com.example.dzSeminar6Ok.controller;

import com.example.dzSeminar6Ok.model.Note;
import com.example.dzSeminar6Ok.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class Controller {
    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.addNote(note),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNote(){
        return new ResponseEntity<>(noteService.findAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>>getNoteId(@PathVariable Long id){
        return new ResponseEntity<>(noteService.getNodeById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@PathVariable Long id,@RequestBody Note note){
         return new ResponseEntity<>(noteService.updateNote(id,note),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
         noteService.deleteNote(id);
         return ResponseEntity.ok().build();
    }
}
