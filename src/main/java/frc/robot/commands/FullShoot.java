package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class FullShoot extends SequentialCommandGroup{
    public FullShoot(){
        addCommands(new ShooterStartCommand(-0.2).withTimeout(2));
    }
    
}

