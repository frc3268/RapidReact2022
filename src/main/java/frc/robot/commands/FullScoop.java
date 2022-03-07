package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class FullScoop extends SequentialCommandGroup {
    /*
     * If we are going to use a system that intakes the balls using flywheels, we
     * are probably going to have them run continuously. We also need a system that
     * could lift up and down like the old scooper.
     */
    public FullScoop() {
        addCommands(new ScoopBall(-0.25).withTimeout(0.6), new ScoopBall(0.25).withTimeout(0.6),
                new ScoopFlywheel(-1).withTimeout(2));
    }

}