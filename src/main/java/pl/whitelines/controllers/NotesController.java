package pl.whitelines.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.whitelines.entities.Note;
import pl.whitelines.services.NotesService;

@RestController("/title")
public class NotesController {
	@Autowired
	private NotesService notesService;
	
	@GetMapping
	public ResponseEntity<List<Note>> getAll() {
		List<Note> notes = notesService.findAll();
		return new ResponseEntity<>(notes, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Note note) {
		notesService.create(note);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
