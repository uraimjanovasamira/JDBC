package org.example.service;

import org.example.Cities;
import org.example.Countries;
import org.example.Presidents;
import org.example.config.DataBaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
    public void createTable() {
        String query = """
                CREATE TABLE cities
                (
                    id         SERIAL PRIMARY KEY,
                    name       VARCHAR,
                    population VARCHAR,
                    square     VARCHAR,
                    mayor      VARCHAR
                );""";

        String query1 = """
                CREATE TABLE countries
                (
                    id         SERIAL PRIMARY KEY,
                    name       VARCHAR,
                    population VARCHAR,
                    square     VARCHAR,
                    president  VARCHAR
                                
                );""";

        String query2 = """
                CREATE TABLE presidents
                (
                    id              SERIAL PRIMARY KEY,
                    name            VARCHAR,
                    lastname        VARCHAR,
                    age             INT,
                    management_time VARCHAR
                );""";


        Connection connection = DataBaseConfig.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(query1);
            statement.execute(query);
            statement.execute(query2);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Countries countries, Presidents presidents, Cities cities) {
        String query = """
                INSERT INTO countries(name,population,square,president)
                VALUES(?,?,?,?);
                """;
        String query1 = """
                INSERT INTO presidents(name,lastname,age,management_time)
                VALUES(?,?,?,?);
                """;
        String query2 = """
                INSERT INTO cities(name,population,square,mayor)
                VALUES(?,?,?,?);
                """;

        try (Connection connection = DataBaseConfig.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, countries.getName());
            preparedStatement.setString(2, countries.getPopulation());
            preparedStatement.setString(3, countries.getSquare());
            preparedStatement.setString(4, countries.getPresident());


            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);

            preparedStatement1.setString(1, presidents.getName());
            preparedStatement1.setString(2, presidents.getLastname());
            preparedStatement1.setInt(3, presidents.getAge());
            preparedStatement1.setInt(4, presidents.getManagement_time());

            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);

            preparedStatement2.setString(1, cities.getName());
            preparedStatement2.setString(2, cities.getMayor());
            preparedStatement2.setInt(3, cities.getPopulation());
            preparedStatement2.setString(4, cities.getSquare());

            preparedStatement.execute();
            preparedStatement1.execute();
            preparedStatement2.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropTables() throws SQLException {
        Connection connection = DataBaseConfig.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE countries");
        statement.execute("DROP TABLE cities");
        statement.execute("DROP TABLE presidents");
        connection.close();
    }
}
