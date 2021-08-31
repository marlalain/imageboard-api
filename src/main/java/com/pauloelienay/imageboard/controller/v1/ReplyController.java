package com.pauloelienay.imageboard.controller.v1;

import com.pauloelienay.imageboard.model.Reply;
import com.pauloelienay.imageboard.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1/replies")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class ReplyController {
    private final ReplyService service;

    @PostMapping
    public ResponseEntity<Reply> createReply(@RequestBody Reply reply) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(
                linkTo(this.getClass()).slash(service.createReply(reply).getId())
                        .toUri());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable long id) {
        service.deleteReplyById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
