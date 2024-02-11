package adapters.in.http;

import adapters.in.http.json.user.CreateUserRequest;
import adapters.in.http.mapper.UserJsonMapper;
import adapters.in.http.security.dto.AuthenticationDTO;
import adapters.in.http.security.dto.AuthenticationResponseDTO;
import adapters.in.http.security.util.JwtTokenUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ports.input.UserInputPort;
import ports.input.user.contract.command.CreateUser;
import ports.input.user.contract.command.CreatedUser;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final AuthenticationManager authenticationManager;
  private final JwtTokenUtil jwtTokenUtil;
  private final UserInputPort userInputPort;
  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;
  private final UserJsonMapper userJsonMapper;

  @PostMapping(value = "/register")
  public ResponseEntity<CreatedUser> registerUser(@RequestBody @Valid CreateUserRequest request) {
    String hashedPassword = passwordEncoder.encode(request.password());
    request =
        new CreateUserRequest(
            request.firstName(),
            request.lastName(),
            request.username(),
            request.email(),
            hashedPassword,
            request.role());
    CreateUser command = userJsonMapper.toCommand(request);
    CreatedUser createdUser = userInputPort.create(command);
    return ResponseEntity.ok().body(createdUser);
  }

  @PostMapping(value = "/authenticate")
  public ResponseEntity<AuthenticationResponseDTO> createAuthenticationToken(
      @RequestBody AuthenticationDTO authenticationRequest) {
    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    final var userDetails =
        userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    final var token = jwtTokenUtil.generateToken(userDetails);
    final var mainRole = userDetails.getAuthorities().stream().findFirst().orElseThrow();
    return ResponseEntity.ok(
        new AuthenticationResponseDTO(token, userDetails.getUsername(), mainRole.getAuthority()));
  }

  private void authenticate(String username, String password) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
  }
}
