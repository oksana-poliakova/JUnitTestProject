package util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */
class PropertiesUtilTest {

    @ParameterizedTest
    @MethodSource("getPropertyArguments")
    void checkGet(String key, String expectedValue) {
        String actualResult = PropertiesUtil.get(key);

        assertEquals(expectedValue, actualResult);
    }

    static Stream<Arguments> getPropertyArguments() {
        return Stream.of(
                Arguments.of("db.url", "jdbc:postgresql://localhost:5433/postgres"),
                Arguments.of("db.user", "postgres"),
                Arguments.of("db.password", "postgres")
        );
    }
}