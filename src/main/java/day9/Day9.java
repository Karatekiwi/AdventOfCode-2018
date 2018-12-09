
package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.list.TreeList;

@SuppressWarnings("unchecked")
public class Day9 {

    private InputHelper  helper       = new InputHelper();

    private TreeList     placement    = new TreeList();

    private int          numPlayers;
    private int          numMarbles;
    private Long         result;
    private int          currentIndex = 1;

    private List<Player> players;

    public void initGame(String line) {
        numPlayers = helper.extractPlayers(line);
        numMarbles = helper.extractNumMarbles(line);
        result = helper.extractResult(line);

        players = initPlayers();
    }

    private List<Player> initPlayers() {
        List<Player> players = new ArrayList<>();

        for (int index = 1; index <= numPlayers; index++) {
            players.add(new Player(index));
        }

        return players;
    }

    public Long getPartOne() {
        int playerIndex = 1;

        // place first and second marble
        placement.add(0L);
        placement.add(1L);

        for (int marbleNum = 2; marbleNum <= numMarbles; marbleNum++) {
            Player player = players.get(playerIndex);

            // get points
            if (marbleNum % 23 == 0) {
                addPointsToPlayer(player, marbleNum);
                removeMarble();
            } else {
                insertMarble(new Long(marbleNum));
            }

            // printLine(player);

            if (playerIndex < players.size() - 1) {
                playerIndex++;
            } else {
                playerIndex = 0;
            }

            // if (marbleNum % 100000 == 0) {
            // System.out.println(marbleNum);
            // }
        }

        Player player = findHighestScorer();
        return player.getScore();
    }

    private Player findHighestScorer() {
        return Collections.max(players, Comparator.comparing(player -> player.getScore()));
    }

    private void removeMarble() {
        int indexToRemove = getMarbel7();
        placement.remove(indexToRemove);
        currentIndex = indexToRemove;
    }

    private int getMarbel7() {
        int indexToRemove = currentIndex - 7;
        if (indexToRemove < 0) {
            indexToRemove = placement.size() + indexToRemove;
        }
        return indexToRemove;
    }

    private void addPointsToPlayer(Player player, int marbleNum) {
        // add the score for marble % 23
        Long score = player.getScore();
        score += marbleNum;

        // add the score for the marble 7 places before
        Long value = (Long) placement.get(getMarbel7());
        score += value;

        player.setScore(score);
    }

    private void insertMarble(Long marbleNum) {
        int size = placement.size();

        int indexForInsert = currentIndex + 2;
        if (indexForInsert < size) {
            placement.add(indexForInsert, marbleNum);
            currentIndex = indexForInsert;
            return;
        }

        indexForInsert = indexForInsert - size;
        if (indexForInsert == 0) {
            placement.add((Long) marbleNum);
            currentIndex = placement.size() - 1;
            return;
        }

        placement.add(indexForInsert, marbleNum);
        currentIndex = indexForInsert;
    }

    private void printLine(Player player) {
        System.out.print(String.format("[%s] ", player.getId()));

        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < placement.size(); index++) {
            Integer integer = (Integer) placement.get(index);
            if (index == currentIndex) {
                builder.append(String.format("(%s) ", integer));
            } else {
                builder.append(String.format("%s ", integer));
            }
        }

        System.out.print(builder.toString());
        System.out.println("");
    }

    public Long getResult() {
        return result;
    }

}
