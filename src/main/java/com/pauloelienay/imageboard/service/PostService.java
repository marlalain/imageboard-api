package com.pauloelienay.imageboard.service;

import com.pauloelienay.imageboard.exception.GenericException;
import com.pauloelienay.imageboard.exception.ResourceNotFoundException;
import com.pauloelienay.imageboard.model.Post;
import com.pauloelienay.imageboard.model.dto.GetPostDto;
import com.pauloelienay.imageboard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    public Page<Post> getPageablePosts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public GetPostDto getPostById(long id) {
        return GetPostDto.convertToDto(repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found.")));
    }

    public Post createPost(Post post) {
        return repository.save(post);
    }

    public void deletePostById(long id) {
        repository.deleteById(id);
    }
}
