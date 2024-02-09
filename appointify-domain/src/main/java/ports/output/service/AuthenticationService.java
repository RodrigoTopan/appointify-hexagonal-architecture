package ports.output.service;

import entity.User;

public interface AuthenticationService {
    User register(User user);

    User unregister(User user);

    User login(User user);
}
