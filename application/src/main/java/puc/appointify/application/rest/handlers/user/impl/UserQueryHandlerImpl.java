package puc.appointify.application.rest.handlers.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import puc.appointify.application.rest.handlers.user.UserQueryHandler;
import puc.appointify.application.rest.handlers.user.contract.query.FindUserQuery;
import puc.appointify.application.rest.handlers.user.contract.query.FindUserQueryResponse;
import puc.appointify.application.rest.handlers.user.mapper.UserMapper;
import ports.output.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserQueryHandlerImpl implements UserQueryHandler {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public FindUserQueryResponse find(FindUserQuery query) {
        var user = userRepository.findByUsername(query.getUsername());
        return userMapper.userToFindUserQueryResponse(user);
    }
}
