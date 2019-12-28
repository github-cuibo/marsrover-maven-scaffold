import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class MarsRoverTest {

    private ExpectedException expectedException;

    @Test
    public void should_move_forward_when_direction_to_east() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.EAST);
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("65E");
    }

    @Test
    public void should_warning_when_land_out_of_area() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("x=20 is out of area width 10");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 20, 30, Rover.SOUTH);
    }

    @Test
    public void should_turn_left() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, Rover.SOUTH);

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55E");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55N");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55W");

        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55S");
    }

    @Test
    public void should_execute_batch_commands() {
        Rover rover = new Rover();
        RoverController roverController = new RoverController(rover);
        String mission = "10, 10, 5, 5, E, M, L, M";
        String position = roverController.execute(mission);
        assertThat(position).isEqualTo("66N");
    }
}
