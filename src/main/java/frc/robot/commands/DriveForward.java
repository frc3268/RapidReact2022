package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class DriveForward extends SequentialCommandGroup{

    public DriveForward(){
        addCommands(new TimedAutonomousArcadeDrive(0.5, 0, 0.5));
    }
    
}
