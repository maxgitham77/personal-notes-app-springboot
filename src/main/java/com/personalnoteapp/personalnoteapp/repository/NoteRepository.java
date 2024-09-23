package com.personalnoteapp.personalnoteapp.repository;

import com.personalnoteapp.personalnoteapp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
