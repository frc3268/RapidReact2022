// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Scooper;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ScoopFlywheel extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final Scooper scooperSubsystem;
  private final double state;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ScoopFlywheel(double state) {
    this.state = state;
    scooperSubsystem = RobotContainer.r_ScooperSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(scooperSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    scooperSubsystem.setScoopFlywheel(state);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    scooperSubsystem.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}