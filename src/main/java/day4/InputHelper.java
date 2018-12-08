
package day4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHelper {

    private SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("mm");

    public int getId(String input) {
        Pattern pattern = Pattern.compile("#(\\d*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String id = matcher.group();
            return Integer.valueOf(id.replace("#", ""));
        }

        return 0;
    }

    public Map<Date, String> getTimeline(List<String> input) {
        Map<Date, String> inputMap = new HashMap<>();

        for (String line : input) {
            inputMap.put(getDate(line), getLine(line));
        }

        return new TreeMap<Date, String>(inputMap);
    }

    private String getLine(String line) {
        return line.split("]")[1].trim();
    }

    private Date getDate(String line) {
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            String date = matcher.group(1);
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public int getMinute(Date date) {
        return Integer.parseInt(sdf2.format(date));
    }
}