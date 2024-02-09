package adapters.in.http.handlers.user.impl;

import adapters.in.http.handlers.user.UserQueryHandler;
import adapters.in.http.handlers.user.contract.query.FindUserQuery;
import adapters.in.http.handlers.user.contract.query.FindUserQueryResponse;
import adapters.in.http.handlers.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.input.UserInputPort;

@Component
@RequiredArgsConstructor
public class UserQueryHandlerImpl implements UserQueryHandler {
    private final UserMapper userMapper;
    private final UserInputPort userInputPort;

    @Override
    public FindUserQueryResponse find(FindUserQuery query) {
        var user = userInputPort.findByUsername(query.getUsername());
        return userMapper.userToFindUserQueryResponse(user);
    }
}
