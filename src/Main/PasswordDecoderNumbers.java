package Main;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class PasswordDecoderNumbers {

    private static String password = "999985111";
    private static StringBuilder string = new StringBuilder("");
    private static int min = 48, max = 58;
    private static long start;
    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordDecoderNumbers.class);

    public static void loop(int index) {
        for (int i = min; i < max; i++) {
            string.setCharAt(index, (char) i);
            if (index < string.length() - 1)
                loop(index + 1);
            //System.out.println(string);
            if (string.toString().equals(password)) {
                System.err.println("Password Found: " + string);
                System.err.println("It took: " + convertmillis(System.currentTimeMillis() - start));
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        start = System.currentTimeMillis();
        System.err.println("Finding password...");
        while (true) {
            string.append((char) min);
            for (int i = 0; i < string.length() - 1; i++) {
                for (int j = min; j < max; j++) {
                    string.setCharAt(i, (char) j);
                    loop(i + 1);
                }
            }

        }
    }

    public static void main2(String[] args) {

    }


    public static String convertmillis(long input) {
        int days = 0, hours = 0, minutes = 0, seconds = 0, millis = 0;

        int day = 86400000;
        int hour = 3600000;
        int minute = 60000;
        int second = 1000;


        if (input >= day) {
            days = (int) (input / day);
            millis = (int) (input % day);
        } else
            millis = (int) input;

        if (millis >= hour) {
            hours = millis / hour;
            millis = millis % hour;
        }

        if (millis >= minute) {
            minutes = millis / minute;
            millis = millis % minute;
        }

        if (millis >= second) {
            seconds = millis / second;
            millis = millis % second;
        }

        return (days + " day(s), " + hours + "h, " + minutes + "min, " + seconds + "s and " + millis + "ms");
    }
}


