package com.aang13.springbootredis;

import com.aang13.springbootredis.hash.Person;
import com.aang13.springbootredis.hash.PersonRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    private PersonRepository personRepository;

    public WebController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/person")
    public Person save(@RequestBody Person person) {
        return this.personRepository.save(person);
    }

    @GetMapping("/person")
    public Person getPerson(@PathParam("name") String name, @PathParam("searchLastName") String searchLastName) {
        if (name != null) {
            return this.personRepository.findByName(name)
                    .orElseThrow(()-> new RuntimeException("Person not found"));
        }
        if(searchLastName != null) {
            return this.personRepository.searchByLastName(searchLastName)
                    .orElseThrow(()-> new RuntimeException("Person not found"));
        }
        return null;
    }
}
