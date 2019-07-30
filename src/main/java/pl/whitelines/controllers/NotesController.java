package pl.whitelines.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.whitelines.DTO.NoteWithIdDTO;
import pl.whitelines.DTO.NoteDTO;
import pl.whitelines.entities.Note;
import pl.whitelines.services.NotesService;

@RestController
@RequestMapping("/notes")
public class NotesController {
	@Autowired
	private NotesService notesService;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public ResponseEntity<List<NoteWithIdDTO>> getAll() {
		Page <Note> notes = notesService.findAll(PageRequest.of(0, 10));
		return new ResponseEntity<List<NoteWithIdDTO>>(convertToList(notes, NoteWithIdDTO.class), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NoteDTO> getOne(@PathVariable("id") long id) {
		Note note = notesService.findOne(id);
		if (note == null) {
			return new ResponseEntity<NoteDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<NoteDTO>(convert(note, NoteDTO.class), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody NoteDTO noteDTO) {
		notesService.create(convert(noteDTO, Note.class));
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<NoteDTO> updateNote(@Valid @RequestBody NoteDTO updateNote, @PathVariable Long id) {	
		Note note = notesService.findOne(id);
		if (note != null) {
			Note updatedNote = notesService.update(note, convert(updateNote, Note.class));
			return new ResponseEntity<NoteDTO>(convert(updatedNote, NoteDTO.class), HttpStatus.OK);
		} else {
			return new ResponseEntity<NoteDTO>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNote(@Valid @PathVariable Long id) {
		notesService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private <T, V> List<V> convertToList(Page<T> input, Class<V> output) {
		return input.stream()
				.map(element -> convert(element, output))
				.collect(Collectors.toList());
	}
	
	private <T, V> V convert(T input, Class<V> output) {
		return modelMapper.map(input, output);
	}
}
