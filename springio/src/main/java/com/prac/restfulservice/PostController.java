package com.prac.restfulservice;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prac.restfulservice.common.Post;
import com.prac.restfulservice.exception.UserNotfoundException;
import com.prac.restfulservice.repository.PostRepository;
import com.prac.restfulservice.repository.UserRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository repo;
	
	@Autowired
	private UserRepository repo1;
	
	@GetMapping("/getpost")
	public List<Post> GetUser() {
		return repo.findAll();
	}
	
//	@GetMapping("/users/{id}")
//	public EntityModel<Post> Getpost(@PathVariable Integer id) {
//		Optional<Post> user= repo.findById(id);
//		if(user.isEmpty()) {
//			throw new UserNotfoundException("id:"+id);
//		}
//		EntityModel<Post> entityModel=EntityModel.of(user.get());
//		
//		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).GetUser());
//		entityModel.add(link.withRel("all-post"));
//		return entityModel;
//	}
	
	@GetMapping("/users/{id}/post")
	public List<Post> Getauser(@PathVariable Integer id) {
		Optional<User> user= repo1.findById(id);
		if(user.isEmpty()) {
			throw new UserNotfoundException("id:"+id);
		}
		
		return user.get().getPosts();
	}
	
	
	@DeleteMapping("/posts/{id}")
	public void Deleteuser(@PathVariable Integer id) {
		
		repo.deleteById(id);
	}
	
}
