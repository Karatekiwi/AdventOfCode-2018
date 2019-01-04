
package challenge;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import day3.Claim;
import day3.Day3;
import day3.InputHelper;

public class Day3Tester {

    private String      input1 = "#31 @ 530,830: 13x20";
    private String      input2 = "#938 @ 101,869: 16x12";
    private String      input3 = "#2 @ 715,698: 18x29";

    private String      claim1 = "#1 @ 1,3: 4x4";
    private String      claim2 = "#2 @ 3,1: 4x4";
    private String      claim3 = "#3 @ 5,5: 2x2";

    private InputHelper helper = new InputHelper();

    @Test
    public void testGetId() {
        int result1 = helper.getId(input1);
        int result2 = helper.getId(input2);
        int result3 = helper.getId(input3);

        assertEquals(31, result1);
        assertEquals(938, result2);
        assertEquals(2, result3);
    }

    @Test
    public void testGetLeftMargin() {
        int result1 = helper.getLeftMargin(input1);
        int result2 = helper.getLeftMargin(input2);
        int result3 = helper.getLeftMargin(input3);

        assertEquals(530, result1);
        assertEquals(101, result2);
        assertEquals(715, result3);
    }

    @Test
    public void testGetTopMargin() {
        int result1 = helper.getTopMargin(input1);
        int result2 = helper.getTopMargin(input2);
        int result3 = helper.getTopMargin(input3);

        assertEquals(830, result1);
        assertEquals(869, result2);
        assertEquals(698, result3);
    }

    @Test
    public void testGetWidth() {
        int result1 = helper.getWidth(input1);
        int result2 = helper.getWidth(input2);
        int result3 = helper.getWidth(input3);

        assertEquals(13, result1);
        assertEquals(16, result2);
        assertEquals(18, result3);
    }

    @Test
    public void testGetHeight() {
        int result1 = helper.getHeight(input1);
        int result2 = helper.getHeight(input2);
        int result3 = helper.getHeight(input3);

        assertEquals(20, result1);
        assertEquals(12, result2);
        assertEquals(29, result3);
    }

    @Test
    public void testTransferToClaim() {
        Day3 challenge = new Day3();
        List<String> input = Arrays.asList(claim1, claim2, claim3);

        List<Claim> claims = challenge.transferToClaims(input);
        assertEquals(3, claims.size());
    }

    @Test
    public void testMaxHeight() {
        Day3 challenge = new Day3();
        List<String> input = Arrays.asList(claim1, claim2, claim3);

        List<Claim> claims = challenge.transferToClaims(input);
        assertEquals(3, claims.size());

        int maxHeight = challenge.getMaxHeight(claims);
        assertEquals(8, maxHeight);
    }

    @Test
    public void testMaxWidth() {
        Day3 challenge = new Day3();
        List<String> input = Arrays.asList(claim1, claim2, claim3);

        List<Claim> claims = challenge.transferToClaims(input);
        assertEquals(3, claims.size());

        int maxWidth = challenge.getMaxWidth(claims);
        assertEquals(8, maxWidth);
    }

    @Test
    public void testFillFabric() {
        Day3 challenge = new Day3();
        List<String> input = Arrays.asList(claim1, claim2, claim3);

        List<Claim> claims = challenge.transferToClaims(input);
        assertEquals(3, claims.size());

        int countOverlappings = challenge.countOverlappings(claims);
        assertEquals(4, countOverlappings);
    }

    @Test
    public void testNoOverlap() {
        Day3 challenge = new Day3();
        List<String> input = Arrays.asList(claim1, claim2, claim3);

        List<Claim> claims = challenge.transferToClaims(input);
        assertEquals(3, claims.size());

        int noOverlap = challenge.getNoOverlap(claims);
        assertEquals(3, noOverlap);
    }

}
