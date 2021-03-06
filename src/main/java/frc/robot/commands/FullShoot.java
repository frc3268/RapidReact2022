package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

public class FullShoot extends SequentialCommandGroup{
    public FullShoot(){
        addCommands(
            new MotorSet(-0.35, RobotContainer.r_ScooperSubsystem),
            new WaitCommand(0.5),
            new MotorSet(0.2, RobotContainer.r_indexOneSubsystem),
            new MotorSet(-0.2, RobotContainer.r_indexTwoSubsystsem),
            new ShooterStartCommand(0.9),
            new WaitCommand(1.5),
            //Stop all motors
            new MotorSet(-0.5, RobotContainer.r_indexTwoSubsystsem),            
            new MotorSet(0.5, RobotContainer.r_indexOneSubsystem),
            new MotorSet(-0.5, RobotContainer.r_ScooperSubsystem),
            new ShooterStartCommand(1));
    }
    
}

