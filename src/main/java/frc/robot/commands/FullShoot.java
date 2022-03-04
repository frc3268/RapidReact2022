package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class FullShoot extends SequentialCommandGroup{
    public FullShoot(){
        addCommands(new ShootBall(0.5).withTimeout(2));
    }
    
}

