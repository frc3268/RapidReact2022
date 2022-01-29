// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.JoystickArcadeDrive;
import frc.robot.commands.TimedAutonomousArcadeDrive;

public class DriveTrain extends SubsystemBase {
  Spark driveLeftFront;
	Spark driveLeftBack;
	Spark driveRightFront;
	Spark driveRightBack;
	SpeedControllerGroup driveLeft;
	SpeedControllerGroup driveRight;
	DifferentialDrive drive;
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    this.drive = new DifferentialDrive(driveLeft, driveRight);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void arcadeDrive(double xSpeed, double zRotation){
    drive.arcadeDrive(xSpeed, zRotation);
  }
  public void stop(){
    drive.stopMotor();
  }

  public void initDefaultCommand(){
    setDefaultCommand(new TimedAutonomousArcadeDrive(new DriveTrain(), 1.0, 1.0, 1.0));
    //probably a bad idea, passing an object into an object
  }
}
