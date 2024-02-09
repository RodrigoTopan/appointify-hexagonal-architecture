package service;

import entity.User;
import ports.input.UserInputPort;
import ports.output.repository.UserRepository;

public class UserDomainService implements UserInputPort {
    private final UserRepository userRepository;

    public UserDomainService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
