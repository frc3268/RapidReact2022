// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//quick comment to test the githubs

package frc.robot.commands;

import frc.robot.subsystems.Scooper;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

/** An example command that uses an example subsystem. */
public class ScoopBall extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Scooper scooperSubsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ScoopBall() {
    scooperSubsystem = RobotContainer.r_ScooperSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(scooperSubsystem);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      scooperSubsystem.setScoop(1.0);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted){
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return false;
  }
  
}
