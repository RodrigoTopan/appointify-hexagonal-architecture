package usecase.user.contract.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoundUser {

    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private String role;
}
