package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoRoutine extends SequentialCommandGroup{

    public AutoRoutine(){
        addCommands(
            new ShooterStartCommand(-0.5).withTimeout(5),
            new TimedAutonomousArcadeDrive(0, -1).withTimeout(5)
        );
    }
    
}
