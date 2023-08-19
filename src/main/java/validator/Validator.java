package validator;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */
public interface Validator <T> {
    ValidatonResult validate(T object);
}
