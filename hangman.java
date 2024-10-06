import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "grape", "orange", "strawberry"};
        String word = words[(int) (Math.random() * words.length)];
        char[] guessedWord = new char[word.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);
        int attemptsLeft = 6;
        boolean wordGuessed = false;

        while (attemptsLeft > 0 && !wordGuessed) {
            System.out.println("\nCurrent word: ");
            for (char c : guessedWord) {
                System.out.print(c + " ");
            }
            System.out.println("\nAttempts left: " + attemptsLeft);
            drawHangman(attemptsLeft);

            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().charAt(0);
            boolean correctGuess = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess && guessedWord[i] == '_') {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attemptsLeft--;
                System.out.println("Wrong guess!");
            }

            wordGuessed = true;
            for (char c : guessedWord) {
                if (c == '_') {
                    wordGuessed = false;
                    break;
                }
            }
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You've guessed the word: " + word);
        } else {
            System.out.println("Game over! The word was: " + word);
        }
        scanner.close();
    }

    public static void drawHangman(int attemptsLeft) {
        switch (attemptsLeft) {
            case 6:
                System.out.println("""
                      +---+
                          |
                          |
                          |
                         ===
                """);
                break;
            case 5:
                System.out.println("""
                      +---+
                      O   |
                          |
                          |
                         ===
                """);
                break;
            case 4:
                System.out.println("""
                      +---+
                      O   |
                      |   |
                          |
                         ===
                """);
                break;
            case 3:
                System.out.println("""
                      +---+
                      O   |
                     /|   |
                          |
                         ===
                """);
                break;
            case 2:
                System.out.println("""
                      +---+
                      O   |
                     /|\\  |
                          |
                         ===
                """);
                break;
            case 1:
                System.out.println("""
                      +---+
                      O   |
                     /|\\  |
                     /    |
                         ===
                """);
                break;
            case 0:
                System.out.println("""
                      +---+
                      O   |
                     /|\\  |
                     / \\  |
                         ===
                """);
                break;
        }
    }
}
