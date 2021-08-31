package com.pauloelienay.imageboard.repository;

import com.pauloelienay.imageboard.model.Reply;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends PagingAndSortingRepository<Reply, Long> {
}
