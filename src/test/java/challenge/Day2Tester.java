
package challenge;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import day2.Day2;

public class Day2Tester {

    @Test
    public void testChecksum() {
        Day2 challenge = new Day2();
        List<String> input = Arrays.asList("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab");
        int checkSum = challenge.getCheckSum(input);
        assertEquals(12, checkSum);
    }

    @Test
    public void testCommonLetter() {
        Day2 challenge = new Day2();
        List<String> input = Arrays.asList("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz");
        String common = challenge.getCommonLetters(input);
        assertEquals("fgij", common);
    }

}
