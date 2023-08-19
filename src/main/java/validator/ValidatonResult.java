package validator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */
public class ValidatonResult {
    @Getter
    private final List<Error> errors = new ArrayList<>();

    public void add(Error error) {
        this.errors.add(error);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
