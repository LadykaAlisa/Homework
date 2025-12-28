package homework15;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionFactory {

    @SneakyThrows
    public Connection getConnection() {
        EnvType envType = EnvType.valueOf(
                System.getProperty("env.type", "LOCAL_DEFAULT"));

        switch (envType) {
            case JENKINS_CHROME:
                return DriverManager.getConnection(
                        "jdbc:mysql://mysql-db-1:3306/db", "root", "11111111");
            default:
                return DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/db", "root", "11111111");
        }
    }
}
