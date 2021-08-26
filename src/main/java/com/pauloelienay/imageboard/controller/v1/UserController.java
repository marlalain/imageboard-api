package com.pauloelienay.imageboard.controller.v1;

import com.pauloelienay.imageboard.model.User;
import com.pauloelienay.imageboard.model.dto.CreateUserDto;
import com.pauloelienay.imageboard.model.dto.GetUserDto;
import com.pauloelienay.imageboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserDto> findOne(@PathVariable long id) {
        return new ResponseEntity<>(service.findOne(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CreateUserDto> create(@RequestBody User user) {
        return new ResponseEntity<>(service.createNew(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable long id) {
        return new ResponseEntity<>(service.update(id, user), HttpStatus.NO_CONTENT);
    }
}
