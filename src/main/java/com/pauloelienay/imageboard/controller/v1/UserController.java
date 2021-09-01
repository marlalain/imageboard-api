package com.pauloelienay.imageboard.controller.v1;

import com.pauloelienay.imageboard.model.User;
import com.pauloelienay.imageboard.model.dto.GetUserDto;
import com.pauloelienay.imageboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService service;

    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<GetUserDto>> findOne(@PathVariable long id) {
        return new ResponseEntity<>(addLinksById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(linkTo(UserController.class).slash(service.createNew(user).getId()).toUri());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EntityModel<GetUserDto>> update(@RequestBody User user, @PathVariable long id) {
        return new ResponseEntity<>(addLinks(service.update(id, user)), HttpStatus.OK);
    }

    EntityModel<GetUserDto> addLinks(User user) {
        return addLinksById(user.getId());
    }

    EntityModel<GetUserDto> addLinksById(Long id) {
        EntityModel<GetUserDto> model = EntityModel.of(service.findOne(id));
        model.add(linkTo(methodOn(this.getClass()).findOne(id)).withSelfRel());
        model.add(linkTo(methodOn(this.getClass()).update(null, id)).withRel("update").withType("PATCH"));
        model.add(linkTo(methodOn(this.getClass()).delete(id)).withRel("delete").withType("DELETE"));
        model.add(linkTo(methodOn(this.getClass()).findAll()).withRel("users"));
        return model;
    }
}
