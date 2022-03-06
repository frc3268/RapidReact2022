package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class AutoRoutine extends SequentialCommandGroup{

    public AutoRoutine(){
        addCommands(
            new ShootBall(-0.5).withTimeout(5),
            new TimedAutonomousArcadeDrive(0, -0.5)
        );
    }
    
}
