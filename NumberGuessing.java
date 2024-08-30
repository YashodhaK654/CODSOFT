import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Create a Random object to generate random numbers
        Random random = new Random();

        // Generate a random number between 1 and 100
        int randomNumber = random.nextInt(100) + 1;

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        int guess = 0;
        int numberOfTries = 0;

        // Start the guessing game
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("Can you guess the number?");

        // Loop until the correct guess is made
        while (guess != randomNumber) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numberOfTries++;

            // Check if the guess is too high, too low, or correct
            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + numberOfTries + " tries.");
            }
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
