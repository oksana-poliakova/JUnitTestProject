package entity;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */
public enum UserRole {
    USER,
    ADMIN;

    public static UserRole find(String role) {
        return findOpt(role).orElseThrow();
    }

    public static Optional<UserRole> findOpt(String role) {
        return Arrays.stream(values())
                .filter(it -> it.name().equals(role))
                .findFirst();
    }
}
