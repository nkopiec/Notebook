package pl.whitelines.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.whitelines.entities.Note;
import pl.whitelines.entities.UpdateNote;
import pl.whitelines.repositories.NotesRepository;
import pl.whitelines.services.NotesService;

@RestController
@RequestMapping("/notes")
public class NotesController {
	@Autowired
	private NotesService notesService;
	
	@GetMapping
	public ResponseEntity<List<Note>> getAll() {
		List<Note> notes = notesService.findAll();
		return new ResponseEntity<>(notes, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Note> getOne(@PathVariable("id") long id) {
		Note note = notesService.findOne(id);
		if (note == null) {
			return new ResponseEntity<Note>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(note, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Note note) {
		notesService.create(note);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateNote(@Valid @RequestBody Note note) {	
		notesService.save(note);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNote(@RequestParam(value="id") Note note) {
		notesService.delete(note);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
