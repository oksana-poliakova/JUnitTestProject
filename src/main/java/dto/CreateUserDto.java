package dto;

import lombok.Builder;
import lombok.Value;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */

@Value
@Builder
public class CreateUserDto {
    String name;
    String birthday;
    String email;
    String password;
    String role;
    String gender;
}
