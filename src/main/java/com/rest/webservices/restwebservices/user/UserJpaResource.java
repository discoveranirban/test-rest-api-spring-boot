package com.rest.webservices.restwebservices.user;

import com.rest.webservices.restwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {
    private UserRepository repository;

    public UserJpaResource(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public User retrieveUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:"+id);

        return user.get();

//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
//        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);
//        mappingJacksonValue.setFilters(filters);
//
//        return mappingJacksonValue;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteById(id);
    }
}
