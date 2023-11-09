import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static String[] questions = {
        "What is the capital of France?",
        "Which planet is known as the Red Planet?",
        "What is the largest mammal in the world?"
    };
    private static String[][] options = {
        {"Berlin", "Madrid", "Paris", "Rome"},
        {"Venus", "Mars", "Jupiter", "Saturn"},
        {"Giraffe", "Elephant", "Blue Whale", "Lion"}
    };
    private static int[] correctAnswers = {3, 2, 3}; // Indices of correct options

    private static int score = 0;
    private static int currentQuestionIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        System.out.println("Welcome to the Quiz Application");
        System.out.println("You have 10 seconds to answer each question.");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! Moving to the next question.");
                showNextQuestion();
            }
        }, 10000, 10000);

        showNextQuestion();
    }

    private static void showNextQuestion() {
        if (currentQuestionIndex < questions.length) {
            System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + questions[currentQuestionIndex]);
            for (int i = 0; i < options[currentQuestionIndex].length; i++) {
                System.out.println((i + 1) + ". " + options[currentQuestionIndex][i]);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of your answer: ");
            int userAnswer = scanner.nextInt();
            checkAnswer(userAnswer);
        } else {
            endQuiz();
        }
    }

    private static void checkAnswer(int userAnswer) {
        if (userAnswer == correctAnswers[currentQuestionIndex]) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect.");
        }
        currentQuestionIndex++;
        showNextQuestion();
    }

    private static void endQuiz() {
        System.out.println("\nQuiz completed!");
        System.out.println("Your final score is: " + score + " out of " + questions.length);

        int correctCount = score;
        int incorrectCount = questions.length - score;
        System.out.println("Correct Answers: " + correctCount);
        System.out.println("Incorrect Answers: " + incorrectCount);
        System.exit(0);
    }
}
