package mapper;

import dto.UserDto;
import entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper <User, UserDto> {
    private static final UserMapper INSTANCE = new UserMapper();

    public static UserMapper getInstance() {
        return INSTANCE;
    }

    @Override
    public UserDto map(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .userRole(object.getUserRole())
                .gender(object.getGender())
                .build();
    }
}
