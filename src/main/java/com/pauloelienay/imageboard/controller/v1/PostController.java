package com.pauloelienay.imageboard.controller.v1;

import com.pauloelienay.imageboard.model.Post;
import com.pauloelienay.imageboard.model.dto.GetPostDto;
import com.pauloelienay.imageboard.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class PostController {
    private final PostService service;

    @GetMapping
    public ResponseEntity<Page<Post>> getPageablePosts(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        return new ResponseEntity<>(service.getPageablePosts(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPostDto> getPostById(@PathVariable long id) {
        return new ResponseEntity<>(service.getPostById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(linkTo(PostController.class).slash(service.createPost(post).getId()).toUri());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable long id) {
        service.deletePostById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
