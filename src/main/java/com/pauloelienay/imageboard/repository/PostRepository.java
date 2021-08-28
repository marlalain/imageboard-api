package com.pauloelienay.imageboard.repository;

import com.pauloelienay.imageboard.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
}
