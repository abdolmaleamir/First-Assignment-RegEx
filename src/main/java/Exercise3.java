import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {

    /*
    implement the method below so that it extracts a URL from a String
    */
    public static String extractURL(String text) {
        String regex ="\\b(?:(?:https?|ftp):\\/\\/|www\\.)[-A-Za-z0-9+&@#\\/%?=~_|!:,.;]*[-A-Za-z0-9+&@#\\/%?=~_|]" ;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }
        else{
            return null;
        }
    }

    /*
    implement the method below to validate an email address
     */

    public static boolean validateEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();


    }

    /*
    implement the method below so that it returns a list of words with repeated letters
    */

    public static List<String> findWordsWithRepeatLetters(String input) {
        List<String> wordsWithRepeatLetters = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w*(\\w)\\w*\\1\\w*");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String word = matcher.group();
            wordsWithRepeatLetters.add(word);
        }
        return wordsWithRepeatLetters;


    }

    /*
    Bonus Problem ;)
    implement the method below so that it returns a list of words that are repeated twice accidentally in a string
    for example: "appleapple orange pearpear pineapple" -> ["appleapple", "pearpear"]
    */

    public static List<String> findReapetdWords(String input) {
        List<String> repeatedWords = new ArrayList<>();
        String[] words = input.split(" ");

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    int k = j + 1;
                    while (k < words.length && words[i].equals(words[k])) {
                        k++;
                    }
                    if (k - j > 1) {
                        repeatedWords.add(words[i] + words[i]);
                    }
                    i = k - 1;
                    break;
                }
            }
        }

        return repeatedWords;
    }

    public static void main(String[] args) {
        // test your code here!
    }
}