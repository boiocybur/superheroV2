import datasource.Database;
import domainmodel.Controller;
import ui.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        Controller controller = new Controller(database);
        UserInterface userInterface = new UserInterface(scanner, controller);
        userInterface.start();
    }
}
