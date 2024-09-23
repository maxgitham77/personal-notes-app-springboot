package com.personalnoteapp.personalnoteapp.service.impl;

import com.personalnoteapp.personalnoteapp.entity.Note;
import com.personalnoteapp.personalnoteapp.repository.NoteRepository;
import com.personalnoteapp.personalnoteapp.service.NoteService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;


    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(Long noteId) {
        Optional<Note> note = noteRepository.findById(noteId);
        return note.get();
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note updateNote(Note note) {
        Note exitingNote = noteRepository.findById(note.getId()).get();
        exitingNote.setTitle(note.getTitle());
        exitingNote.setBody(note.getBody());
        exitingNote.setCategory(note.getCategory());
        Note updatedNote = noteRepository.save(exitingNote);
        return updatedNote;
    }

    @Override
    public void deleteNote(Long noteId) {
        noteRepository.deleteById(noteId);
    }
}
