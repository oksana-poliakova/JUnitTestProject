package exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import validator.Error;

import java.util.List;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */

public class ValidationException extends RuntimeException {
    @Getter
    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
}
