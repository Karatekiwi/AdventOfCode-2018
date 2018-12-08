
package day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHelper {

    public int getWidth(String input) {
        Pattern pattern = Pattern.compile("(?<=\\:)(.*?)(?=x)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String width = matcher.group().trim();
            return Integer.valueOf(width);
        }

        return 0;
    }

    public int getTopMargin(String input) {
        Pattern pattern = Pattern.compile("(?<=\\,)(.*?)(?=\\:)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String top = matcher.group().trim();
            return Integer.valueOf(top);
        }

        return 0;
    }

    public int getLeftMargin(String input) {
        Pattern pattern = Pattern.compile("(?<=\\@)(.*?)(?=\\,)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String left = matcher.group().trim();
            return Integer.valueOf(left);
        }

        return 0;
    }

    public int getHeight(String input) {
        Pattern pattern = Pattern.compile("x(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String width = matcher.group().trim();
            width = width.replace("x", "");
            return Integer.valueOf(width);
        }

        return 0;
    }

    public int getId(String input) {
        Pattern pattern = Pattern.compile("(?<=\\#)(.*?)(?=\\@)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String idString = matcher.group().trim();
            return Integer.valueOf(idString);
        }

        return 0;
    }

}
