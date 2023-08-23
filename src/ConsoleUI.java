package src;

import java.util.Scanner;

class ConsoleUI implements UI {
    public static final String QUIT_COMMAND = "q";

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine().trim();
    }
}