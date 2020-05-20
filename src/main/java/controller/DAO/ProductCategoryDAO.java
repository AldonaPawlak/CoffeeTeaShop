package controller.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryDAO extends DataBaseDAO implements DAO{

    @Override
    public void select() {
        try{
            connect();
            connection.setAutoCommit(false);
            ResultSet rs = statement.executeQuery( "SELECT * FROM Categories;" );  //tabela z zestawem wyników zapytania
            while ( rs.next() ) {
                int id = rs.getInt("Id_category");
                String  name = rs.getString("Name");
                String description  = rs.getString("Description");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "SURNAME = " + description );
                System.out.println();
            }
//            rs.close();
//            statement.close();
//            connection.close();

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

    }
}
