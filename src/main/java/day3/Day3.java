
package day3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import challenge.AdventOfCode;

public class Day3 extends AdventOfCode {

    InputHelper helper = new InputHelper();

    public void initGame(String path) {
        List<String> input = readStringLines(path);

        List<Claim> claims = transferToClaims(input);
        int countOverlappings = countOverlappings(claims);
        System.out.println(String.format("There are %s overlappings.", countOverlappings));

        int noOverlap = getNoOverlap(claims);
        System.out.println(String.format("The claim with no overlap has the following id: %s.", noOverlap));
    }

    public int countOverlappings(List<Claim> claims) {
        List<Field> overlappings = new ArrayList<>();

        String fabric[][] = new String[getMaxWidth(claims)][getMaxHeight(claims)];
        fillFabric(claims, overlappings, fabric);

        print(fabric);

        return overlappings.size();
    }

    private void fillFabric(List<Claim> claims, List<Field> overlappings, String[][] fabric) {
        for (Claim claim : claims) {
            int id = claim.getId();
            int leftMargin = claim.getLeftMargin();
            int width = claim.getWidth();
            int height = claim.getHeight();
            int topMargin = claim.getTopMargin();

            for (int index = 0; index < width; index++) {
                for (int index2 = 0; index2 < height; index2++) {

                    int x = topMargin + index2;
                    int y = leftMargin + index;

                    String field = fabric[x][y];
                    if (field == null) {
                        fabric[x][y] = id + "";
                    } else {
                        fabric[x][y] = "x";

                        if (overlappings == null) {
                            continue;
                        }

                        Field xyField = new Field(x, y);
                        if (!overlappings.contains(xyField)) {
                            overlappings.add(xyField);
                        }
                    }
                }
            }
        }
    }

    public int getNoOverlap(List<Claim> claims) {
        String fabric[][] = new String[getMaxWidth(claims)][getMaxHeight(claims)];

        fillFabric(claims, null, fabric);

        int noOverlapId = 0;
        for (Claim claim : claims) {
            int id = claim.getId();
            int leftMargin = claim.getLeftMargin();
            int width = claim.getWidth();
            int height = claim.getHeight();
            int topMargin = claim.getTopMargin();
            boolean overlaps = false;

            for (int index = 0; index < width; index++) {
                for (int index2 = 0; index2 < height; index2++) {

                    int x = topMargin + index2;
                    int y = leftMargin + index;

                    String field = fabric[x][y];
                    if (field.equals("x")) {
                        overlaps = true;
                    }
                }
            }

            if (!overlaps) {
                noOverlapId = id;
            }
        }

        return noOverlapId;
    }

    public void print(String[][] fabric) {
        for (String[] name : fabric) {
            for (String string : name) {
                if (string == null) {
                    System.out.print(".");
                } else {
                    System.out.print(string);
                }
            }
            System.out.println("");
        }
    }

    public int getMaxHeight(List<Claim> claims) {
        Optional<Claim> max = claims.stream().max(new Comparator<Claim>() {

            @Override
            public int compare(Claim c1, Claim c2) {
                int c1All = c1.getHeight() + c1.getTopMargin();
                int c2All = c2.getHeight() + c2.getTopMargin();

                return Integer.compare(c1All, c2All);
            }
        });

        return max.get().getHeight() + max.get().getTopMargin() + 1;
    }

    public int getMaxWidth(List<Claim> claims) {
        Optional<Claim> max = claims.stream().max(new Comparator<Claim>() {

            @Override
            public int compare(Claim c1, Claim c2) {
                int c1All = c1.getWidth() + c1.getLeftMargin();
                int c2All = c2.getWidth() + c2.getLeftMargin();

                return Integer.compare(c1All, c2All);
            }
        });

        return max.get().getWidth() + max.get().getLeftMargin() + 1;
    }

    public List<Claim> transferToClaims(List<String> inputList) {
        List<Claim> claims = new ArrayList<>();

        for (String input : inputList) {

            Claim claim = new Claim();
            claim.setHeight(helper.getHeight(input));
            claim.setId(helper.getId(input));
            claim.setLeftMargin(helper.getLeftMargin(input));
            claim.setTopMargin(helper.getTopMargin(input));
            claim.setWidth(helper.getWidth(input));

            claims.add(claim);
        }

        return claims;
    }

}
