import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wordle{
    private static final int WORD_LENGTH = 5;
    private static final int MAX_GUESSES = 10;
    private static final List<String> WORD_LIST = new ArrayList<>();

    static {
        // Load word list from file or database
        WORD_LIST.add("house");
        WORD_LIST.add("apple");
        WORD_LIST.add("table");
        WORD_LIST.add("chair");
        WORD_LIST.add("phone");
        WORD_LIST.add("angel");
        WORD_LIST.add("beach");
        WORD_LIST.add("bread");
        WORD_LIST.add("chair");
        WORD_LIST.add("cloud");
        WORD_LIST.add("dance");
        WORD_LIST.add("earth");
        WORD_LIST.add("fairy");
        WORD_LIST.add("ghost");
        WORD_LIST.add("house");
        WORD_LIST.add("jewel");
        WORD_LIST.add("lemon");
        WORD_LIST.add("magic");
        WORD_LIST.add("ocean");
        WORD_LIST.add("panda");
        WORD_LIST.add("quiet");
        WORD_LIST.add("river");
        WORD_LIST.add("smile");
        WORD_LIST.add("tiger");
        WORD_LIST.add("umbra");
        WORD_LIST.add("voice");
        WORD_LIST.add("arrow");
        WORD_LIST.add("brave");
        WORD_LIST.add("chime");
        WORD_LIST.add("dream");
        WORD_LIST.add("flame");
        WORD_LIST.add("happy");
        WORD_LIST.add("image");
        WORD_LIST.add("jelly");
        WORD_LIST.add("loyal");
        WORD_LIST.add("maple");
        WORD_LIST.add("north");
        WORD_LIST.add("peace");
        WORD_LIST.add("quest");
        WORD_LIST.add("round");
        WORD_LIST.add("storm");
        WORD_LIST.add("unity");
        WORD_LIST.add("vital");
        WORD_LIST.add("watch");
        WORD_LIST.add("young");
        WORD_LIST.add("zebra");
        WORD_LIST.add("awake");
        WORD_LIST.add("bliss");
        WORD_LIST.add("cloud");
        WORD_LIST.add("early");
        WORD_LIST.add("fairy");
        WORD_LIST.add("grace");
        WORD_LIST.add("heart");
        WORD_LIST.add("jewel");
        WORD_LIST.add("light");
        WORD_LIST.add("music");
        WORD_LIST.add("oasis");
        WORD_LIST.add("power");
        WORD_LIST.add("quiet");
        WORD_LIST.add("shape");
        WORD_LIST.add("space");
        WORD_LIST.add("sweet");
        WORD_LIST.add("voice");
        WORD_LIST.add("arrow");
        WORD_LIST.add("bliss");
        WORD_LIST.add("color");
        WORD_LIST.add("earth");
        WORD_LIST.add("fairy");
        WORD_LIST.add("glimp");
        WORD_LIST.add("happy");
        WORD_LIST.add("ideal");
        WORD_LIST.add("jewel");
        WORD_LIST.add("knack");
        WORD_LIST.add("loyal");
        WORD_LIST.add("money");
        WORD_LIST.add("night");
        WORD_LIST.add("overt");
        WORD_LIST.add("pearl");
        WORD_LIST.add("quiet");
        WORD_LIST.add("rebel");
        WORD_LIST.add("sharp");
        WORD_LIST.add("tidal");
        WORD_LIST.add("urban");
        WORD_LIST.add("vital");
        WORD_LIST.add("xerox");
        WORD_LIST.add("yacht");
        WORD_LIST.add("zesty");
        WORD_LIST.add("alive");
        WORD_LIST.add("brave");
        WORD_LIST.add("candy");
        WORD_LIST.add("diver");
        WORD_LIST.add("elbow");
        WORD_LIST.add("flora");
        WORD_LIST.add("genre");
        WORD_LIST.add("honey");
        WORD_LIST.add("image");
        WORD_LIST.add("jolly");
        WORD_LIST.add("laser");
        WORD_LIST.add("mango");
        WORD_LIST.add("nexus");
        WORD_LIST.add("ozone");
        WORD_LIST.add("peach");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String targetWord = getRandomWord();
        int guessesLeft = MAX_GUESSES;

        while (guessesLeft > 0) {
            System.out.print("Enter a " + WORD_LENGTH + "-letter word: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() != WORD_LENGTH) {
                System.out.println("Invalid word length. Try again!");
                continue;
            }

            if (!WORD_LIST.contains(guess)) {
                System.out.println("Invalid word. Try again!");
                continue;
            }

            char[] guessArray = guess.toCharArray();
            char[] targetArray = targetWord.toCharArray();
            boolean[] correctLetters = new boolean[WORD_LENGTH];

            for (int i = 0; i < WORD_LENGTH; i++) {
                if (guessArray[i] == targetArray[i]) {
                    correctLetters[i] = true;
                }
            }

            printGuessResult(correctLetters);

            if (isCorrectGuess(correctLetters)) {
                System.out.println(" Congratulations! You won!");
                break;
            }

            guessesLeft--;
            System.out.println("Guesses left: " + guessesLeft);
        }

        if (guessesLeft == 0) {
            System.out.println("Game over! The correct answer was: " + targetWord);
        }
    }

    private static String getRandomWord() {
        return WORD_LIST.get((int) (Math.random() * WORD_LIST.size()));
    }

    private static void printGuessResult(boolean[] correctLetters) {
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (correctLetters[i]) {
                System.out.print("[ " + correctLetters[i] + " ] ");
            } else {
                System.out.print("[ _ ] ");
            }
        }
        System.out.println();
    }

    private static boolean isCorrectGuess(boolean[] correctLetters) {
        for (boolean correctLetter : correctLetters) {
            if (!correctLetter) {
                return false;
            }
        }
        return true;
    }
}