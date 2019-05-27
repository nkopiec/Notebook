package pl.whitelines.services;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.whitelines.entities.Note;
@Service
public interface NotesService {
	List<Note> findAll();
	void create(Note note);
	void delete(Long id);
	Note findOne(Long id);
	void save(Note note);
	Note update(Note oldNote, Note updateNote);
}
