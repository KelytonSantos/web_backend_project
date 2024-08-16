package com.project.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping("/all")
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Lord", "Lord.com", "9999999", "19777422");
        return ResponseEntity.ok().body(u);
    }
}
