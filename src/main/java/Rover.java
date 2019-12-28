public class Rover {
    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String SOUTH = "S";
    public static final String NORTH = "N";

    private int x;
    private int y;
    private String direction;

    public void move() {
        x += 1;
    }

    public void land(Area area, int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String getPosition() {
        return "" + x + y + direction;
    }

    public void turnLeft() {
        if (direction == "E")
            direction = "N";
        if (direction == "S")
            direction = "E";
        if (direction == "W")
            direction = "S";
        if (direction == "N")
            direction = "W";
    }
}
