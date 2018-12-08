
package day2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Day2Tester {

    @Test
    public void testChecksum() {
        List<String> input = Arrays.asList("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab");
        int checkSum = Day2.getCheckSum(input);
        assertEquals(12, checkSum);
    }

    @Test
    public void testCommonLetter() {
        List<String> input = Arrays.asList("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz");
        String common = Day2.getCommonLetters(input);
        assertEquals("fgij", common);
    }

}
