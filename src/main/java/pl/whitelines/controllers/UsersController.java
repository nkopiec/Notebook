package pl.whitelines.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.whitelines.DTO.UserDTO;

@RestController
public class UsersController {
    @Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping("/check-user")
	public ResponseEntity<Void> login(@Valid @RequestBody UserDTO userDTO, HttpServletRequest request, HttpServletResponse response) {
		UsernamePasswordAuthenticationToken token =
				new UsernamePasswordAuthenticationToken(userDTO.getLogin(), userDTO.getPassword());
		try {
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<Void>(HttpStatus.OK);
		} catch(BadCredentialsException execption) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	}
}
