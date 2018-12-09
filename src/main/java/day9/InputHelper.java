
package day9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHelper {

    public int extractPlayers(String input) {
        Pattern pattern = Pattern.compile("(\\d*) players");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String numPlayers = matcher.group();
            return Integer.valueOf(numPlayers.replace(" players", ""));
        }

        return 0;
    }

    public int extractNumMarbles(String input) {
        Pattern pattern = Pattern.compile("(\\d*) points");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String numMarbles = matcher.group();
            return Integer.valueOf(numMarbles.replace(" points", ""));
        }

        return 0;
    }

    public Long extractResult(String input) {
        Pattern pattern = Pattern.compile("high score is (\\d*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String result = matcher.group();
            return Long.valueOf(result.replace("high score is ", ""));
        }

        return 0L;
    }

}