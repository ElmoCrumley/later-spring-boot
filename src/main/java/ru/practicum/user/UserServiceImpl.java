package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public List<UserDTO> getAllUsers() {
        return UserDTO.fromList(repository.findAll());
    }

    @Override
    @Transactional
    public UserDTO saveUser(User user) {
        return UserDTO.from(repository.save(user));
    }
}