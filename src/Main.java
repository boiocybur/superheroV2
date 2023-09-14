import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        Controller controller = new Controller(database);

        // Creates and starts userInterface
        UserInterface userInterface = new UserInterface(scanner, database, controller);
        userInterface.start();
    }
}
