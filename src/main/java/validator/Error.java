package validator;

import lombok.Value;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */

@Value(staticConstructor = "of")
public class Error {
    String code;
    String message;
}
