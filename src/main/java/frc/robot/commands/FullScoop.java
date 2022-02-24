package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class FullScoop extends SequentialCommandGroup{

    public FullScoop(){
        addCommands(
            new ScoopBall(0.25).withTimeout(0.5),
            new ScoopBall(-0.25).withTimeout(0.5)
        );
    }
    
}
