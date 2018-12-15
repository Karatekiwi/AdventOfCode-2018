package day15;

public class Location {

	private Player player;
	private boolean wall;
	private int x;
	private int y;

	public Location(int x, int y, boolean wall) {
		this.x = x;
		this.y = y;
		this.wall = wall;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isWall() {
		return wall;
	}

	public void setWall(boolean wall) {
		this.wall = wall;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
