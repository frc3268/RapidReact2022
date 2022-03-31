// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//quick comment to test the githubs

package frc.robot.commands;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

/** An example command that uses an example subsystem. */
public class ShooterStartCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Shooter shooterSubsystem;
  private final double speed;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShooterStartCommand(double speed) {
    this.speed = speed;
    shooterSubsystem = RobotContainer.r_ShooterSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooterSubsystem);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      shooterSubsystem.toggleMotor(speed);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted){
    //shooterSubsystem.stop();
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return true;
  }
  
}
