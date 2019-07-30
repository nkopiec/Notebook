package pl.whitelines.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.whitelines.DTO.UserDTO;
import pl.whitelines.entities.User;
import pl.whitelines.services.UsersService;

@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@PostMapping("/login")
	public ResponseEntity<Void> login(@Valid @RequestBody UserDTO userDTO) {
		User user = usersService.findUser(userDTO.getLogin(), userDTO.getPassword());
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
