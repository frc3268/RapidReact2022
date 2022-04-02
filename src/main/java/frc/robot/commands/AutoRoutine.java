package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoRoutine extends SequentialCommandGroup{

    public AutoRoutine(){
        addCommands(
            new FullShoot(),
            new TimedAutonomousArcadeDrive(0, -1).withTimeout(3),
            new FullShoot()
        );
    }
    
}
