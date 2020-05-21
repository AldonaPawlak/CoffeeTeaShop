package com.codecool.coffeeteashop.controller.DAO;

import com.codecool.coffeeteashop.view.Input;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO extends DataBaseDAO implements DAO{
    Input input = new Input();

    public void select() {
        try{
            connect();
            connection.setAutoCommit(false);
            ResultSet rs = statement.executeQuery( "SELECT * FROM Products;" );
            while ( rs.next() ) {
                int id = rs.getInt("id_product");
                String  name = rs.getString("Name");
                String  description = rs.getString("Description");
                double price = rs.getFloat("Price");
                int quantity = rs.getInt("Quantity");
                int idCategory = rs.getInt("Id_category");
                boolean isAvailable = rs.getBoolean("isAvailable");

                System.out.println( "Id = " + id );
                System.out.println( "Name = " + name );
                System.out.println( "Description = " + description );
                System.out.println( "Price = " + price );
                System.out.println( "Quantity = " + quantity );
                System.out.println( "Id_category = " + idCategory );
                System.out.println("isAvailable = " + isAvailable);
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

    }

    @Override
    public void insertInto() {
        String name = input.getStringInput("Enter new name of the product: ");
        String description = input.getStringInput("Enter description: ");
        int price = input.getIntegerInput("Enter price: ");
        int quantity = input.getIntegerInput("Enter quantity: ");
        int idCategory = input.getIntegerInput("Enter id category ");
        boolean isAvailable = true;

        try {
            connect();
            connection.setAutoCommit(false);
            String sql = String.format("INSERT INTO Products (Name,Description, Price, Quantity, Id_category, isAvailable) " +
                    "VALUES ('%s', '%s', '%d', '%d', '%d', '%b');", name, description, price, quantity, idCategory, isAvailable);
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
