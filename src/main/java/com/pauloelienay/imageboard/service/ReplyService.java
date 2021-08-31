package com.pauloelienay.imageboard.service;

import com.pauloelienay.imageboard.model.Reply;
import com.pauloelienay.imageboard.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository repository;

    public Reply createReply(Reply reply) {
        return repository.save(reply);
    }

    public void deleteReplyById(long id) {
        repository.deleteById(id);
    }
}
