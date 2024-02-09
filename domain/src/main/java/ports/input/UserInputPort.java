package ports.input;

import entity.User;

public interface UserInputPort {
    User findByUsername(String username);
}
