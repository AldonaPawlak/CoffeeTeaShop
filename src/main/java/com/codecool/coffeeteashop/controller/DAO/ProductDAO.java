package com.codecool.coffeeteashop.controller.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO extends DataBaseDAO implements DAO{

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

    }

    @Override
    public void delete() {

    }

    @Override
    public void insertInto() {
        try {
            connect();
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Categories (Name, Description) " +
                    "VALUES ('Coffee cups', 'Ceramika Bolesławiec');";
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
