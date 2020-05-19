package controller.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DataBaseDAO<Object> {
    protected Connection connection;
    protected Statement statement;

    public static final String DB_NAME = "src/main/resources/coffeTeaShop.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public void connect() {
        this.connection = null;
        this.statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(CONNECTION_STRING);
            this.statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database" + e.getMessage());
        }
    }
}