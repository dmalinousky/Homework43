import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework43Main {
    public static void main(String[] args) throws IOException {
        passwordCheck();
    }

    public static void passwordCheck() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // Conditions
            System.out.println("Create a password. Its requirements:" +
                    "\n1. Length from 8 to 100 symbols." +
                    "\n2. Gotta include at least 1 capital letter." +
                    "\n3. Gotta include at least 1 small letter." +
                    "\n4. Gotta include at least 1 number.");

            // User's input
            String password = reader.readLine();

            // A couple of patterns cuz user's combinations may be different
            Pattern pattern1 = Pattern.compile("[A-Z]+"); // >= 1 capital
            Pattern pattern2 = Pattern.compile("[a-z]+"); // >= 1 lowercase
            Pattern pattern3 = Pattern.compile("[0-9]+"); // >= 1 number
            Pattern pattern4 = Pattern.compile("[^\s]"); // no spaces
            Matcher matcher1 = pattern1.matcher(password);
            Matcher matcher2 = pattern2.matcher(password);
            Matcher matcher3 = pattern3.matcher(password);
            Matcher matcher4 = pattern4.matcher(password);

            // Checking if all the patterns were found
            if (
                    !matcher4.find()
                    && matcher1.find()
                    && matcher2.find()
                    && matcher3.find()
                    && password.length() >= 8
                    && password.length() <= 100
            ) {
                System.out.println("Password accepted!");
                break;
            } else {
                System.out.println("Incorrect! Try again!");
            }
        }
    }
}
