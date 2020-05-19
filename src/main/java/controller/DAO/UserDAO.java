package controller.DAO;

import java.sql.*;

public class UserDAO extends DataBaseDAO implements DAO{

    public UserDAO(){
    }
    @Override
    public void select() {
        try{
            connect();
            connection.setAutoCommit(false);
            ResultSet rs = statement.executeQuery( "SELECT * FROM Users;" );
            while ( rs.next() ) {
                int id = rs.getInt("Id_user");
                String  name = rs.getString("Name");
                String surname  = rs.getString("Surname");
                String mail = rs.getString("e-mail");
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

    }

    @Override
    public void delete() {

    }

    @Override
    public void insertInto() {
        try {
            connect();
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Users (Id_user,Name,Surname,e-mail,Password,Phone,rights) " +
                    "VALUES (2, 'Paul', 'Nowak', 'nowak@onet.pl', 'nowak1234', 123456789,'customer');";
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
