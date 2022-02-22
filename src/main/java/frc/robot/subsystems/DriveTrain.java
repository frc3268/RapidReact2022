// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.JoystickArcadeDrive;

public class DriveTrain extends SubsystemBase {
  Spark driveLeftFront;
	Spark driveLeftBack;
	Spark driveRightFront;
	Spark driveRightBack;
	MotorControllerGroup driveLeft;
	MotorControllerGroup driveRight;
  DifferentialDrive drive;
  boolean isInverted = false;
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    this.driveLeftFront = new Spark(RobotMap.SPARK_driveLeftFront);
    //this.driveLeftBack = new Spark(RobotMap.SPARK_driveLeftBack);
    //this.driveRightBack = new Spark(RobotMap.SPARK_driveRightBack);
    this.driveRightFront = new Spark(RobotMap.SPARK_driveRightFront);
    this.driveLeft = new MotorControllerGroup(driveLeftFront);
    this.driveRight = new MotorControllerGroup(driveRightFront);
    this.drive = new DifferentialDrive(driveLeft, driveRight);
    this.driveRight.setInverted(true);
    this.driveLeft.setInverted(true);
  }
  public void SwapControls()
	{
		driveLeft.setInverted(!(driveLeft.getInverted()));
		driveRight.setInverted(!(driveRight.getInverted()));	
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
    setDefaultCommand(new JoystickArcadeDrive());
    //probably a bad idea, passing an object into an object
  }
}
