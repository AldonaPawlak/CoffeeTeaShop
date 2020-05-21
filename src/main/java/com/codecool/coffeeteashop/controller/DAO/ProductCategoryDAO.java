package com.codecool.coffeeteashop.controller.DAO;

import com.codecool.coffeeteashop.view.Input;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryDAO extends DataBaseDAO implements DAO{

    Input input = new Input();

    @Override
    public void select() {
        try{
            connect();
            connection.setAutoCommit(false);
            ResultSet rs = statement.executeQuery( "SELECT * FROM Categories;" );
            while ( rs.next() ) {
                int id = rs.getInt("Id_category");
                String  name = rs.getString("Name");
                String description  = rs.getString("Description");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "DESCRIPTION = " + description );
                System.out.println();
            }
            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

        // TODO
        // must be repaired

        String name = input.getStringInput("Enter name: ");
        String description = input.getStringInput("Enter description: ");
        try {
            connect();
            connection.setAutoCommit(false);
            String sql = String.format("UPDATE Categories set Name = '%s' where Id_user = 1;");
            statement.executeUpdate(sql);
            connection.commit();

            statement.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    @Override
    public void delete() {
        try {
            connect();
            connection.setAutoCommit(false);
            String sql = "DELETE from Products where Id_category = 2 AND Id_product = 2;";
            statement.executeUpdate(sql);
            connection.commit();

            statement.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    @Override
    public void insertInto() {
        String name = input.getStringInput("Enter the new name of category: ");
        String description = input.getStringInput("Enter description: ");
        try {
            connect();
            connection.setAutoCommit(false);
            String sql = String.format("INSERT INTO Categories (Name,Description) " +
                    "VALUES ('%s', '%s');", name, description);
            statement.executeUpdate(sql);

            statement.close();
            connection.commit();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
