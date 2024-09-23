package com.personalnoteapp.personalnoteapp.controller;

import com.personalnoteapp.personalnoteapp.entity.Note;
import com.personalnoteapp.personalnoteapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin("*")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note savedNote = noteService.createNote(note);
        return new ResponseEntity<>(savedNote, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable("id") Long noteId) {
        Note note = noteService.getNoteById(noteId);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") Long noteId, @RequestBody Note note) {
        note.setId(noteId);
        Note updatedNote = noteService.updateNote(note);
        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") Long noteId) {
        noteService.deleteNote(noteId);
        return new ResponseEntity<>("Note deleted successfully!", HttpStatus.OK);
    }


}
