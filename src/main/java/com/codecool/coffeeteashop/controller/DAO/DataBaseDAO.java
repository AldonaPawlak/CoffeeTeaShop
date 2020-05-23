package com.codecool.coffeeteashop.controller.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DataBaseDAO<Object> {
    protected static Connection connection;
    protected Statement statement; // Statement to interfejs reprezentujący instrukcję SQL. Wykonujesz Statementobiekty, a one generują ResultSetobiekty, które są tabelą danych reprezentującą zestaw wyników bazy danych. Potrzebujesz Connectionobiektu, aby go utworzyć Statement

    public static final String DB_NAME = "src/main/resources/coffeTeaShop.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public void connect() {

        this.statement = null;
        try {
            if (connection == null){
                Class.forName("org.sqlite.JDBC"); // inicjalizujemy sterownik
                connection = DriverManager.getConnection(CONNECTION_STRING);
            }
            this.statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database" + e.getMessage());
        }
    }
}
