package pl.whitelines.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.whitelines.DTO.TitleData;
import pl.whitelines.entities.Notes;
import pl.whitelines.services.NotesService;

@RestController
public class NotesController {
	@Autowired
	private NotesService notesService;
	
	@PostMapping("/title")
	public ResponseEntity<Void> title(@RequestBody TitleData titleData) {
		Notes notes = notesService.findOneNotes(titleData.getId(), titleData.getTitle());
		if (notes == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}		
}
