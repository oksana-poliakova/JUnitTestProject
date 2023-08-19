package validator;

import dto.CreateUserDto;
import entity.Gender;
import entity.UserRole;
import util.LocalDateFormatter;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */
public class CreateUserValidator implements Validator<CreateUserDto> {
    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidatonResult validate(CreateUserDto object) {
        var validationResult = new ValidatonResult();
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if (Gender.findOpt(object.getGender()).isEmpty()) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        if (UserRole.findOpt(object.getRole()).isEmpty()) {
            validationResult.add(Error.of("invalid.role", "Role is invalid"));
        }
        return validationResult;
    }
}
