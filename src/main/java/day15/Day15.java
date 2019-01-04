
package day15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import challenge.AdventOfCode;
import day15.Player.Type;

public class Day15 extends AdventOfCode {

    private Location[][] area;
    private List<Player> players = new ArrayList<>();

    public void initGame(String file, int sizeX, int sizeY) {
        area = new Location[sizeX][sizeY];

        List<String> lines = readStringLines(file);
        initArea(lines);
        move();
    }

    private void move() {
        print();

        for (int index = 0; index < 2; index++) {
            movePlayers();
            print();
        }
    }

    private void movePlayers() {
        for (Player player : players) {
            List<Location> possible = calculatePossibleMoves(player);
            Location chosen = chooseNearest(possible);

            // moveToLocation(player, chosen);
        }
    }

    private void moveToLocation(Player player, Location chosen) {
        player.setPosX(chosen.getX());
        player.setPosY(chosen.getY());
    }

    private Location chooseNearest(List<Location> possible) {
        return null;
    }

    private List<Location> calculatePossibleMoves(Player player) {
        List<Location> possible = new ArrayList<>();
        List<Player> targets = getTargets(player.getType());

        int posX = player.getPosX();
        int posY = player.getPosY();

        return possible;
    }

    private List<Player> getTargets(Type type) {
        return players.stream().filter(player -> !player.getType().equals(type)).collect(Collectors.toList());
    }

    private void initArea(List<String> lines) {
        int currentId = 0;
        for (int ys = 0; ys < area.length; ys++) {
            String line = lines.get(ys);

            char[] charArray = line.toCharArray();
            for (int xs = 0; xs < charArray.length; xs++) {
                String letter = String.valueOf(charArray[xs]);
                boolean isWall = "#".equals(letter);

                Location location = new Location(xs, ys, isWall);
                area[ys][xs] = location;
                Player newPlayer = null;

                if ("G".equals(letter)) {
                    newPlayer = createPlayer(Type.G, xs, ys);
                }

                if ("E".equals(letter)) {
                    newPlayer = createPlayer(Type.E, xs, ys);
                }

                if (newPlayer != null) {
                    newPlayer.setId(String.valueOf(currentId));
                    location.setPlayer(newPlayer);
                    currentId++;
                }
            }
        }
    }

    private Player createPlayer(Type goblin, int x, int y) {
        Player player = new Player();
        player.setHitPoints(200);
        player.setPosX(x);
        player.setPosY(y);
        player.setType(goblin);
        players.add(player);

        return player;
    }

    public void print() {
        for (int ys = 0; ys < area.length; ys++) {
            Location[] line = area[ys];

            for (int xs = 0; xs < line.length; xs++) {
                Location location = area[ys][xs];
                if (location.isWall()) {
                    System.out.print("#");
                } else {
                    Player player = location.getPlayer();
                    if (player != null) {
                        System.out.print(player.getType().name());
                    } else {
                        System.out.print(".");
                    }
                }
            }

            System.out.println("");
        }

        System.out.println("");
    }

}
