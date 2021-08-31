package com.pauloelienay.imageboard.service;

import com.pauloelienay.imageboard.exception.GenericException;
import com.pauloelienay.imageboard.exception.ResourceNotFoundException;
import com.pauloelienay.imageboard.model.User;
import com.pauloelienay.imageboard.model.dto.GetUserDto;
import com.pauloelienay.imageboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public GetUserDto findOne(long id) {
        return GetUserDto.convertToDto(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found.")));
    }

    public User findOneFull(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
    }

    public User createNew(User user) {
        return repository.save(user);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public User update(long id, User user) {
        repository.findById(id).ifPresent(_unused -> {
            user.setId(id);
            repository.save(user);
        });
        return user;
    }
}
