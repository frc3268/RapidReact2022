package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class FullShoot extends ParallelCommandGroup{
    public FullShoot(){
        addCommands(new MotorSet(-0.5, RobotContainer.r_indexOneSubsystem).withTimeout(2),
         new MotorSet(-0.5, RobotContainer.r_indexTwoSubsystsem).withTimeout(2));
    }
    
}

