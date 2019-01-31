package pl.whitelines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.whitelines.entities.Notes;
import pl.whitelines.repositories.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService{
	@Autowired
	private NotesRepository notesRepository;
	
	@Override
	public Notes findOneNotes(Long id, String title) {
		return notesRepository.findByIdAndTitle(id, title);
	}
}
