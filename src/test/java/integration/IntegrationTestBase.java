package integration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import util.ConnectionManager;

import java.sql.SQLException;

/**
 * @author oksanapoliakova on 19.08.2023
 * @projectName JUnitTestProject
 */
public abstract class IntegrationTestBase {
    private static final String CLEAN_SQL = "DELETE FROM users;";
    private static final String CREATE_SQL = """
            CREATE TABLE IF NOT EXISTS users
            (
                id INT PRIMARY KEY ,
                name VARCHAR(64) NOT NULL,
                birthday DATE NOT NULL ,
                email VARCHAR(64) NOT NULL UNIQUE ,
                password VARCHAR(64) NOT NULL ,
                role VARCHAR(32) NOT NULL ,
                gender VARCHAR(16) NOT NULL
            );
            """;

    @BeforeAll
    static void prepareDatabase() throws SQLException {
        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement()) {
            statement.execute(CREATE_SQL);
        }
    }

    @BeforeEach
    void cleanData() throws SQLException {
        try (var connection = ConnectionManager.get();
             var statement = connection.createStatement()) {
            statement.execute(CLEAN_SQL);
        }
    }
}
