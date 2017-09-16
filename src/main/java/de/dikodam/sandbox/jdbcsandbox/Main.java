package de.dikodam.sandbox.jdbcsandbox;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        createNewDB("test.db");
    }

    private static void connect() {
        String url = "jdbc:sqlite:memory";
        try (Connection con = DriverManager.getConnection(url)) {
            System.out.println("Connection established!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createNewDB(String fileName) {
        String url = "jdbc:sqlite:S:/sqlite/db/" + fileName;
        try(Connection connection = DriverManager.getConnection(url)) {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println("The driver name is " + metaData.getDriverName());
                System.out.println("A new DB has been created!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
