package adapters.in.http.handlers.user;

import adapters.in.http.handlers.user.contract.query.FindUserQuery;
import adapters.in.http.handlers.user.contract.query.FindUserQueryResponse;

public interface UserQueryHandler {
    FindUserQueryResponse find(FindUserQuery query);
}
