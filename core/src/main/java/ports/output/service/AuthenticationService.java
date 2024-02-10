package ports.output.service;

import domain.entity.User;

public interface AuthenticationService {
  User register(User user);

  User unregister(User user);

  User login(User user);
}
