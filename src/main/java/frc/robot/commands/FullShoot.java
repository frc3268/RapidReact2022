package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

public class FullShoot extends SequentialCommandGroup{
    public FullShoot(){
        addCommands(
            new ShooterStartCommand(1),
            new WaitCommand(1),
            new MotorSet(0.5, RobotContainer.r_indexOneSubsystem),
            new MotorSet(-0.5, RobotContainer.r_indexTwoSubsystsem),
            new WaitCommand(3),
            new ShooterStartCommand(1),
            new MotorSet(0.5, RobotContainer.r_indexOneSubsystem),
            new MotorSet(-0.5, RobotContainer.r_ScooperSubsystem));
    }
    
}

