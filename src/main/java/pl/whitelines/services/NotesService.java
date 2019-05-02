package pl.whitelines.services;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.whitelines.entities.Note;
@Service
public interface NotesService {
	List<Note> findAll();
	void create(Note note);
	void delete(Note note);
	Note findOne(Long id);
	void save(Note note);
}
