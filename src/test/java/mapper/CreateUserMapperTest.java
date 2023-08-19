package mapper;

import dto.CreateUserDto;
import entity.Gender;
import entity.User;
import entity.UserRole;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */
class CreateUserMapperTest {
    private final CreateUserMapper mapper = CreateUserMapper.getInstance();

    @Test
    void map() {
        CreateUserDto dto = CreateUserDto.builder()
                .name("Ivan")
                .email("test@gmail.com")
                .password("123")
                .birthday("2000-01-01")
                .role(UserRole.USER.name())
                .gender(Gender.MALE.name())
                .build();

        User actualResult = mapper.map(dto);

        User expectedResult = User.builder()
                .name("Ivan")
                .gender(Gender.MALE)
                .userRole(UserRole.USER)
                .email("test@gmail.com")
                .password("123")
                .birthday(LocalDate.of(2000, 1, 1))
                .build();
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}