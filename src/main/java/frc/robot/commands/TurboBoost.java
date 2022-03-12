// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//quick comment to test the githubs

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

/** An example command that uses an example subsystem. */
public class TurboBoost extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain driveTrainSubsystem;
  private final int speed;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TurboBoost(int speedvar) {
    driveTrainSubsystem = RobotContainer.r_driveTrainSubsystem;
    this.speed = Math.abs(speedvar);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrainSubsystem);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double correctedspeedmod = Math.abs(driveTrainSubsystem.speedmod);
    correctedspeedmod = (driveTrainSubsystem.speedmod == 3) ?  1 : driveTrainSubsystem.speedmod*speed;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted){
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    System.out.println(driveTrainSubsystem.speedmod == 3);
    return true;
  }
  
}
