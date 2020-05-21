package com.codecool.coffeeteashop.controller.DAO;

import com.codecool.coffeeteashop.model.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO extends DataBaseDAO implements DAO {
    private User user;

    public OrderDAO(User user){
        this.user = user;
    }

    @Override
    public void select() {
        connect();
        try{
            connect();
            connection.setAutoCommit(false);
            ResultSet rs = statement.executeQuery( "SELECT * FROM Orders;" );
            while ( rs.next() ) {
                int id = rs.getInt("Id_order");
                int  idCustomer = rs.getInt("Id_customer");
                String orderStatus  = rs.getString("Order_status");
                Date paidAt = rs.getDate("Order_payAt");
                Date createdAt = rs.getDate("Order_createdAt");


                System.out.println( "Id_order = " + id );
                System.out.println( "Id_customer = " + idCustomer );
                System.out.println( "Order_status = " + orderStatus );
                System.out.println( "Order_payAt = " + paidAt );
                System.out.println( "Order_createdAt = " + createdAt );
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
            String sql = "UPDATE Orders set Order_status = 'Payed' where Id_order = 1;";
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
            String sql = "DELETE from Orders where Id_order = 2;";
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

        try {
            connect();
            connection.setAutoCommit(false);
            String sql = String.format("INSERT INTO Orders (Id_Customer,Order_status,Order_payAt,Order_createdAt) " +
                    "VALUES ('%d', '%s', '%t', %t',);", user.getId(), "paid", 20122020, 21122020);
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
