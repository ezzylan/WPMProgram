import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        int[] timeout = { 3, 2, 1 };
        String[] words = { "promise", "correction", "drawer", "warrant", "greet", "timber", "cooperation", "proclaim",
                "confidence", "glacier", "economy", "context", "entertain", "parachute", "biscuit", "sentiment",
                "settlement", "subway", "function", "locate", "picture", "return", "problem", "smile", "lodge",
                "prosecute", "attack", "ambiguous", "borrow", "guide", "deficit", "crisis", "infinite", "discreet",
                "feminist", "liberal", "athiest", "religious", "politics", "government", "transform", "sunrise",
                "financial", "protest", "distortion", "feeling", "landscape", "request", "invisible", "feedback" };

        // start countdown before program starts
        System.out.println("\nThis is where the fun begins!");
        TimeUnit.SECONDS.sleep(1);
        for (int time : timeout) {
            System.out.println(time);
            TimeUnit.SECONDS.sleep(1);
        }

        // print 50 random words from the words list
        Random r = new Random();
        for (int i = 0; i < r.nextInt(50); i++) {
            System.out.print(words[r.nextInt(words.length)] + " ");
        }
        System.out.println();

        // get exact nanoseconds of the day before user enters input
        double start = LocalTime.now().toNanoOfDay();

        // receive input from user
        String typedWords = s.nextLine();

        // get exact nanoseconds of the day after user enters input
        double end = LocalTime.now().toNanoOfDay();

        // calculate the time taken for user to enter input
        double elapsedTime = end - start;
        double seconds = elapsedTime / 1000000000;

        // calculate the words per minute
        int numChars = typedWords.length();
        int wpm = (int) ((((double) numChars / 5) / seconds) * 60);
        System.out.println("\nYour WPM is " + wpm + "!");

        // give feedback on user's typing speed
        if (wpm >= 100) {
            System.out.println("You're in the top 1% of typists. Congratulations!");
        } else if (wpm >= 90) {
            System.out.println("At this speed, you're probably a gamer, coder, or genius. You're doing great!");
        } else if (wpm >= 80) {
            System.out.println("You're a catch! Any employer looking for a typist would love to have you.");
        } else if (wpm >= 70) {
            System.out.println(
                    "You are way above average and would qualify for any typing job, assuming your accuracy is high enough.");
        } else if (wpm >= 60) {
            System.out.println("This is the speed required for most jobs. You can now be a professional typist!");
        } else if (wpm >= 50) {
            System.out.println("Congratulations! You're above average.");
        } else if (wpm >= 40) {
            System.out.println(
                    "At this speed, you're now an average typist! However, you still have significant room for improvement.");
        } else if (wpm >= 30) {
            System.out.println("Better, but still below average. Keep practicing to improve your speed and accuracy!");
        } else if (wpm >= 20) {
            System.out.println("Equivalent to one word every 3 seconds. Focus on your technique and keep practicing!");
        } else {
            System.out.println(
                    "Equivalent to one word every 6 seconds. Learn the proper typing technique and practice to improve your speed!");
        }
    }
}
