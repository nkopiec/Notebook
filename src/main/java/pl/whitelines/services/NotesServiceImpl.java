package pl.whitelines.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import pl.whitelines.entities.Note;
import pl.whitelines.repositories.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService {
	@Autowired
	private NotesRepository notesRepository;
	
	
	@Override
	public List<Note> findAll() {
		return notesRepository.findAll();
	}
	
	@Override
	public Note findOne(Long id) {
		return notesRepository.findById(id).orElse(null);
	}

	@Override
	public void create(Note note) {
		note.setId(null);
		notesRepository.save(note);
	}
	
	@Override
	public void save(Note note) {
		note.setId(null);
		notesRepository.save(note);
	}
	
	@Override
	public void delete(Long id) {
		notesRepository.deleteById(id);
	}

	@Override
	public Note update(Note oldNote, Note updateNote) {
		oldNote.setText(updateNote.getText());
		oldNote.setTitle(updateNote.getTitle());
		return notesRepository.save(oldNote);
	}

	@Override
	public Page<Note> findAll(PageRequest of) {
		return notesRepository.findAll(of);
	}
}
