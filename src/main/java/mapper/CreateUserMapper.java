package mapper;

import dto.CreateUserDto;
import entity.Gender;
import entity.UserRole;
import entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import util.LocalDateFormatter;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserMapper implements Mapper<CreateUserDto, User>  {
    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public User map(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.findOpt(object.getGender()).orElse(null))
                .userRole(UserRole.findOpt(object.getRole()).orElse(null))
                .build();
    }
}
