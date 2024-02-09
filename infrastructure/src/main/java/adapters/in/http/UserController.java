package adapters.in.http;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import adapters.in.http.security.dto.AuthenticationDTO;
import adapters.in.http.security.dto.AuthenticationResponseDTO;
import adapters.in.http.security.util.JwtTokenUtil;
import usecase.user.contract.command.CreateUserCommand;
import usecase.user.contract.command.CreateUserCommandResponse;
import ports.input.UserInputPort;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserInputPort userInputPort;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/register")
    public ResponseEntity<CreateUserCommandResponse> registerUser(
            @RequestBody @Valid CreateUserCommand command) {

        var hashedPassword = passwordEncoder.encode(command.getPassword());
        command.setPassword(hashedPassword);

        return ResponseEntity.ok()
                .body(userInputPort.create(command));
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> createAuthenticationToken(@RequestBody AuthenticationDTO authenticationRequest) {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final var userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final var token = jwtTokenUtil.generateToken(userDetails);
        final var mainRole = userDetails.getAuthorities()
                .stream()
                .findFirst()
                .orElseThrow();
        return ResponseEntity.ok(new AuthenticationResponseDTO(token, userDetails.getUsername(), mainRole.getAuthority()));
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
