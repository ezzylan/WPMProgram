import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int[] timeout = { 3, 2, 1 };
        String[] words = { "promise", "correction", "drawer", "warrant", "greet", "timber", "cooperation", "proclaim",
                "confidence", "glacier" };

        // start countdown before program starts
        for (int time : timeout) {
            System.out.println(time);
            TimeUnit.SECONDS.sleep(1);
        }

        // print 10 random words based on the words list
        Random r = new Random();
        for (String word : words) {
            System.out.print(words[r.nextInt(words.length)] + " ");
        }
        System.out.println();

        // get exact nanoseconds of the day before user enters input
        double start = LocalTime.now().toNanoOfDay();

        // receive input from user
        Scanner s = new Scanner(System.in);
        String typedWords = s.nextLine();

        // get exact nanoseconds of the day after user enters input
        double end = LocalTime.now().toNanoOfDay();

        // calculate the time taken for user to enter input
        double elapsedTime = end - start;
        double seconds = elapsedTime / 1000000000;

        // calculate the words per minute
        int numChars = typedWords.length();
        int wpm = (int) ((((double) numChars / 5) / seconds) * 60);
        System.out.println("Your WPM is " + wpm + "!");
        s.close();

    }
}
