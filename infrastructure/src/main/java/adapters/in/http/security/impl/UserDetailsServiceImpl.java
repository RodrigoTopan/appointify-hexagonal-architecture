package adapters.in.http.security.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import adapters.in.http.handlers.user.UserQueryHandler;
import adapters.in.http.handlers.user.contract.query.FindUserQuery;
import adapters.in.http.handlers.user.contract.query.FindUserQueryResponse;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserQueryHandler userQueryHandler;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final FindUserQueryResponse userQueryResponse = userQueryHandler
                .find(FindUserQuery
                        .builder()
                        .username(username)
                        .build());

        return UserDetailsImpl
                .builder()
                .username(userQueryResponse.getUsername())
                .password(userQueryResponse.getPassword())
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_" + userQueryResponse.getRole())))
                .build();
    }
}
