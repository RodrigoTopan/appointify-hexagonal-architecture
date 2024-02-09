package puc.appointify.application.rest.handlers.user;

import puc.appointify.application.rest.handlers.user.contract.query.FindUserQuery;
import puc.appointify.application.rest.handlers.user.contract.query.FindUserQueryResponse;

public interface UserQueryHandler {
    FindUserQueryResponse find(FindUserQuery query);
}
