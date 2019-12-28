
public class RoverController {
    public RoverController(Rover rover) {
    }

    public String execute(String mission) {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.EAST);
        rover.move();
        rover.turnLeft();
        rover.move();
        return rover.getPosition();
    }
}
