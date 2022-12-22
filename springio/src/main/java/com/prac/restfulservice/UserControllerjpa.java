package com.prac.restfulservice;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.jpa.repository.JpaRepository;
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
import com.prac.restfulservice.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserControllerjpa {

	private MessageSource meassagesource;
	
	private UserRepository repo;
	
	
	
	public UserControllerjpa(MessageSource meassagesource, UserRepository repo) {
		super();
		this.meassagesource = meassagesource;
		this.repo = repo;
	}

	@GetMapping("/users")
	public List<User> GetUser() {
		return repo.findAll();
	}
	
	@GetMapping("/internal")
	public String GetUserInternationalized() {
		Locale locale=LocaleContextHolder.getLocale();
		return meassagesource.getMessage("good.morning.message", null, "Default Message", locale);
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> Getauser(@PathVariable Integer id) {
		Optional<User> user= repo.findById(id);
		if(user.isEmpty()) {
			throw new UserNotfoundException("id:"+id);
		}
		EntityModel<User> entityModel=EntityModel.of(user.get());
		
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).GetUser());
		entityModel.add(link.withRel("all-user"));
		return entityModel;
	}
	
	@PostMapping("/users1")
	public ResponseEntity<User> postuser(@Valid @RequestBody User user) {
	
		User save=new UserDAOservice().create(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/users/{id}")
	public void Deleteuser(@PathVariable Integer id) {
		
		repo.deleteById(id);
	}
}
