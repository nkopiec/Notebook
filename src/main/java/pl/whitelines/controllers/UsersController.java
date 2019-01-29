package pl.whitelines.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.whitelines.DTO.LoginData;
import pl.whitelines.entities.User;
import pl.whitelines.services.UsersService;

@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody LoginData loginData) {
		User user = usersService.findUser(loginData.getLogin(), loginData.getPassword());
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
