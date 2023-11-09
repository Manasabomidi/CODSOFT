import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Game!");
        System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");

        do {
            int targetNumber = random.nextInt(maxRange) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (" + (attempts + 1) + "/" + maxAttempts + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + targetNumber);
                    score++;
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }

                attempts++;
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            rounds++;

            System.out.print("Do you want to play another round? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Game Over!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Score: " + score);

        scanner.close();
    }
}
