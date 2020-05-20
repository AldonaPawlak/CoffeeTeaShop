import controller.DAO.DAO;
import controller.DAO.ProductCategoryDAO;
import controller.DAO.ProductDAO;
import controller.DAO.UserDAO;
import controller.Login;
import controller.MenuController;
import controller.Registration;
import view.Input;
import view.UI;

public class Program {
    private Input input = new Input();
    private UI ui = new UI();
    private MenuController menuController;
    private UserDAO userDAO = new UserDAO();
    private ProductDAO productDAO = new ProductDAO();
    private ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();

    public void runProgram() {
        ui.printMenu();
        int userOption = input.getIntegerInput("Enter option: ");
        switch (userOption){
            case 1:
                ui.print("Login");
                Login login = new Login();
                userDAO.insertInto();  //  raz wsadzony obiekt nie może byc wsadzony drugi raz dlatego ta funkcja wywala błąd bo jest na sztywno
//                userDAO.select();
//                ui.print("--------");
//                userDAO.update();
//                userDAO.select();
//                ui.print("--------");
                //userDAO.delete(); tutaj tak samo, jak sie usunie raz dany obiekt to nie da się drugi raz go usunąć
//                productDAO.select();
//                productDAO.insertInto();
//                productCategoryDAO.select();
                break;
            case 2:
                ui.print("Registration");
                Registration registration = new Registration();
                break;
            case 0:
                break;
            default:
                ui.print("Wrong option");
                runProgram();
                break;
        }
    }
}
