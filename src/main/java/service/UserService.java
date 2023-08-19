package service;

import dao.UserDao;
import dto.CreateUserDto;
import dto.UserDto;
import exception.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import mapper.CreateUserMapper;
import mapper.UserMapper;
import validator.CreateUserValidator;

import java.util.Optional;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */

@RequiredArgsConstructor
public class UserService {
    private final CreateUserValidator createUserValidator;
    private final UserDao userDao;
    private final CreateUserMapper createUserMapper;
    private final UserMapper userMapper;

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(userMapper::map);
    }

    @SneakyThrows
    public UserDto create(CreateUserDto userDto) {
        var validationResult = createUserValidator.validate(userDto);
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.map(userDto);
        userDao.save(userEntity);

        return userMapper.map(userEntity);
    }
}
