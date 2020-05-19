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

    public void runProgram() {
        ui.printMenu();
        int userOption = input.getIntegerInput("Enter option: ");
        switch (userOption){
            case 1:
                ui.print("Login");
                Login login = new Login();
                userDAO.insertInto();
                userDAO.select();
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
