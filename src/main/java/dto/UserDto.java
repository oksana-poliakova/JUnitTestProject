package dto;

import entity.Gender;
import entity.UserRole;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */

@Value
@Builder
public class UserDto {
    Integer id;
    String name;
    LocalDate birthday;
    String email;
    UserRole userRole;
    Gender gender;
}
