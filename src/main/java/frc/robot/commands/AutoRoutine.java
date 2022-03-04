package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class AutoRoutine extends SequentialCommandGroup{

    public AutoRoutine(){
        addCommands(
            new TimedAutonomousArcadeDrive(0, 0, 0.5).withTimeout(1),
            new ShootBall(0.5),
            new TimedAutonomousArcadeDrive(0, 0, 0.5).withInterrupt(() -> RobotContainer.r_powerDistributor.getTotalCurrent() < 7),
            new FullScoop(),
            new ShootBall(0.5),
            new TimedAutonomousArcadeDrive(0, 1, 0.5)
        );
    }
    
}
