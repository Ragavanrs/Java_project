package com.prac.restfulservice;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prac.restfulservice.exception.UserNotfoundException;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private MessageSource meassagesource;
	
	public UserController(MessageSource messageSource) {
		this.meassagesource=messageSource;
		
	}
	
	@GetMapping("/")
	public List<User> GetUser() {
		return new UserDAOservice().findAll();
	}
	
	@GetMapping("/inter")
	public String GetUserInternationalized() {
		Locale locale=LocaleContextHolder.getLocale();
		return meassagesource.getMessage("good.morning.message", null, "Default Message", locale);
	}
	
	@GetMapping("/user/{id}")
	public EntityModel<User> Getauser(@PathVariable Integer id) {
		User user= new UserDAOservice().findone(id);
		if(user==null) {
			throw new UserNotfoundException("id:"+id);
		}
		EntityModel<User> entityModel=EntityModel.of(user);
		
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).GetUser());
		entityModel.add(link.withRel("all-user"));
		return entityModel;
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> postuser(@Valid @RequestBody User user) {
	
		User save=new UserDAOservice().create(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/user/{id}")
	public void Deleteuser(@PathVariable Integer id) {
		new UserDAOservice().DeleteUser(id);
		
	}
}
