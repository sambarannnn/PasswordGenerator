import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n\n\t\t\t\t\t\tWelcome To Password Generator!\n");

        Generator password = new Generator();
        password.parameters();
        password.generate();
        System.out.println("Password generated!\nPress ENTER key to view.\n");
        s.nextLine();
        System.out.println("\nPASSWORD : " + password.get());
    }
}
