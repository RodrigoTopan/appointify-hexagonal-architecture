package adapters.in.http.json;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {

  private UUID id;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String role;
}
