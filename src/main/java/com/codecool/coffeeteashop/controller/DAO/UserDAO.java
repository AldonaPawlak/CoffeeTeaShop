package com.codecool.coffeeteashop.controller.DAO;

import com.codecool.coffeeteashop.model.User;
import com.codecool.coffeeteashop.view.Input;

import java.io.IOException;
import java.sql.*;

public class UserDAO<Person> extends DataBaseDAO implements DAO{

    private final Input input  = new Input();
    private User user;

    public UserDAO(){
    }
    @Override
    public void select() {
        connect();
        try{
            connection.setAutoCommit(false);
            ResultSet rs = statement.executeQuery( "SELECT * FROM Users;" );
            while ( rs.next() ) {
                int id = rs.getInt("Id_user");
                String  name = rs.getString("Name");
                String surname  = rs.getString("Surname");
                String mail = rs.getString("mail");
                String password = rs.getString("Password");
                int phone = rs.getInt("Phone");
                String rights = rs.getString("rights");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "SURNAME = " + surname );
                System.out.println( "E-MAIL = " + mail );
                System.out.println( "Password = " + password );
                System.out.println("Phone = " + phone);
                System.out.println("rights = " + rights);
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
            String sql = "UPDATE Users set Name = 'Putek' where Id_user = 1;";
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
            String sql = "DELETE from Users where Id_user = 2;";
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
        String name = input.getStringInput("Enter name: ");
        String surname = input.getStringInput("Enter surname: ");
        String email = input.getStringInput("Enter email: ");
        String password = input.getStringInput("Enter password: ");
        int phone = input.getNumericInput("Enter phone number: ", 0, 999999999);
        String rights = "customer";
        try {
            connect();
            connection.setAutoCommit(false);
            String sql = String.format("INSERT INTO Users (Name,Surname,mail,Password,Phone,rights) " +
                    "VALUES ('%s', '%s', '%s', '%s', %d,'%s');", name, surname, email, password, phone, rights);
            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public User selectUser() throws IOException {
        String userEmail = input.getStringInput("Enter your email: ");
        String userPassword = input.getStringInput("Enter your password: ");
        connect();
        try{
            connect();
            connection.setAutoCommit(false);
            ResultSet rs = statement.executeQuery( String.format("SELECT * FROM Users WHERE mail='%s'AND Password='%s' ;", userEmail, userPassword) );
            while ( rs.next() ) {
                int id = rs.getInt("Id_user");
                String name = rs.getString("Name");
                String surname = rs.getString("Surname");
                String mail = rs.getString("mail");
                String password = rs.getString("Password");
                int phone = rs.getInt("Phone");
                String rights = rs.getString("rights");

                if (mail!=null & password!=null){
                    User user = new User(id, name, surname, mail, password, phone, rights);
                    return user;
                }
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
