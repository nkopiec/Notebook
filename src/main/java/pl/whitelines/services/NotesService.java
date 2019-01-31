package pl.whitelines.services;

import org.springframework.stereotype.Service;

import pl.whitelines.entities.Notes;
@Service
public interface NotesService {
	public Notes findOneNotes(Long Id, String title);
	public Notes findAllNotes();
	
}
