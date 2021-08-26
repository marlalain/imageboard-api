package com.pauloelienay.imageboard.repository;

import com.pauloelienay.imageboard.model.User;
import com.pauloelienay.imageboard.model.dto.GetUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
