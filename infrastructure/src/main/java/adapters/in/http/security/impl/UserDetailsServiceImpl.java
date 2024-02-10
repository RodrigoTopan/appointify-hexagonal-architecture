package adapters.in.http.security.impl;

import usecase.user.contract.query.FindUser;
import usecase.user.contract.query.FoundUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ports.input.UserInputPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserInputPort userInputPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final FoundUser userQueryResponse = userInputPort
                .find(new FindUser(username));

        return UserDetailsImpl
                .builder()
                .username(userQueryResponse.username())
                .password(userQueryResponse.password())
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_" + userQueryResponse.role())))
                .build();
    }
}
