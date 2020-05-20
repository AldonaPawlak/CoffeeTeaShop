package controller;
import view.Input;
import controller.DAO.ProductCategoryDAO;

public class AdminMenuController {

    Input input = new Input();
    ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();

    private void addProductCategory() {
        System.out.println("ADDING NEW PRODUCT CATEGORY");
        String name = input.getStringInput("Enter a name for the category: ");
        productCategoryDAO.insertInto();
    }
}
