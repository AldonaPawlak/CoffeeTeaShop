package com.codecool.coffeeteashop.controller.DAO;

import com.codecool.coffeeteashop.view.Input;

import java.io.IOException;
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
                int rating = rs.getInt("Rating");
                int numberOfRates = rs.getInt("Number_of_rates");

                System.out.println( "Id = " + id );
                System.out.println( "Name = " + name );
                System.out.println( "Description = " + description );
                System.out.println( "Price = " + price );
                System.out.println( "Quantity = " + quantity );
                System.out.println( "Id_category = " + idCategory );
                System.out.println("isAvailable = " + isAvailable);
                System.out.println("Rating = " + rating/numberOfRates);
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
    public void delete() throws IOException {
        final Integer idCategory = input.getIntegerInput("Type Category ID: ");
        final Integer idProduct = input.getIntegerInput("Type product ID: ");
        try {
            connect();
            connection.setAutoCommit(false);
            String sql = String.format("DELETE FROM Products WHERE Id_category = '%d' AND Id_product = '%d'", idCategory, idProduct +
                    "VALUES ('Id_category', 'Id_product')", idCategory, idProduct);
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
    public void insertInto() throws IOException {
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

    public void selectSpecificCategory(int categoryId){
        try{
            connect();
            connection.setAutoCommit(false);
            ResultSet resultSets = statement.executeQuery( String.format("SELECT * FROM Products where Id_category = %d;", categoryId ));
            while ( resultSets.next() ) {
                int id = resultSets.getInt("id_product");
                String  name = resultSets.getString("Name");
                String  description = resultSets.getString("Description");
                double price = resultSets.getFloat("Price");
                int quantity = resultSets.getInt("Quantity");
                int idCategory = resultSets.getInt("Id_category");
                boolean isAvailable = resultSets.getBoolean("isAvailable");
                int rating = resultSets.getInt("Rating");
                int numberOfRates = resultSets.getInt("Number_of_rates");

                System.out.println( "Id = " + id );
                System.out.println( "Name = " + name );
                System.out.println( "Description = " + description );
                System.out.println( "Price = " + price );
                System.out.println( "Quantity in shop = " + quantity );
                System.out.println( "Id_category = " + idCategory );
                System.out.println("isAvailable = " + isAvailable);
                System.out.println("Rating = " + rating/numberOfRates);
                System.out.println();
            }
            resultSets.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectSpecificProductAvailability(int productId) {
        try{
            connect();
            connection.setAutoCommit(false);
            ResultSet resultSets = statement.executeQuery( String.format("SELECT isAvailable, Quantity FROM Products where Id_product = %d;", productId ));
            while ( resultSets.next() ) {
                int quantity = resultSets.getInt("Quantity");
                boolean isAvailable = resultSets.getBoolean("isAvailable");
                String avalibility = isAvailable == true ? "available" : "not available";
                System.out.println( "Quantity in shop = " + quantity );
                System.out.println("isAvailable = " + avalibility);
                System.out.println();
            }
            resultSets.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateRating(String productName, int productRating) {
        int rating = 0;
        int ratingNumber = 0;
        try {
            connect();
            connection.setAutoCommit(false);
            ResultSet resultSets = statement.executeQuery(String.format("SELECT Rating, Number_of_rates FROM Products where Name = '%s';", productName));
            while (resultSets.next()) {
                rating = resultSets.getInt("Rating");
                ratingNumber = resultSets.getInt("Number_of_rates");
            }
            int productRatingToSave = rating + productRating;
            ratingNumber ++;
            String sql = String.format("UPDATE Categories set Rating = %d, Number_of_rates = %d where Name = '%s';", productRatingToSave, ratingNumber, productName);
            statement.executeUpdate(sql);
            connection.commit();

            statement.close();
            connection.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }


    public void selectAllProductsWithRates() {
        try{
            connect();
            connection.setAutoCommit(false);
            ResultSet rs = statement.executeQuery( "SELECT Name, Rating FROM Products;" );
            while ( rs.next() ) {
                String  name = rs.getString("Name");
                int  rating = rs.getInt("Rating");

                System.out.println( "Name = " + name );
                System.out.println( "Rating = " + rating );
            }
            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

