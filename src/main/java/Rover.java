public class Rover {
    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String SOUTH = "S";
    public static final String NORTH = "N";

    private int x;
    private int y;
    private String direction;

    public void move() {
        if (direction.equals(Rover.EAST))
            x += 1;
        if (direction.equals(Rover.WEST))
            x -= 1;
        if (direction.equals(Rover.SOUTH))
            y -= 1;
        if (direction.equals(Rover.NORTH))
            y += 1;
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
        if (direction.equals(Rover.EAST)) {
            direction = Rover.NORTH;
            return;
        }


        if (direction.equals(Rover.SOUTH)) {
            direction = Rover.EAST;
            return;
        }

        if (direction.equals(Rover.WEST)) {
            direction = Rover.SOUTH;
            return;
        }

        if (direction.equals(Rover.NORTH)) {
            direction = Rover.WEST;
            return;
        }

    }
}
