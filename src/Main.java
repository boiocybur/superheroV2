import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        Controller controller = new Controller(database);

        // Opret UserInterface og start brugerdialogen
        UserInterface userInterface = new UserInterface(scanner, database, controller);
        userInterface.start();
    }
}
