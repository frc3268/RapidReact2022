// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.JoystickArcadeDrive;

public class DriveTrain extends SubsystemBase {
  Talon driveLeftFront;
	Talon driveLeftBack;
	Talon driveRightFront;
	Talon driveRightBack;
	MotorControllerGroup driveLeft;
	MotorControllerGroup driveRight;
  DifferentialDrive drive;
  public int speedmod = 1;
  // + (OI.button_one.get() ? 1 : 0);
  boolean isInverted = false;
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    this.driveLeftFront = new Talon(RobotMap.SPARK_driveLeftFront);
    //this.driveLeftBack = new Spark(RobotMap.SPARK_driveLeftBack);
    //this.driveRightBack = new Spark(RobotMap.SPARK_driveRightBack);
    this.driveRightFront = new Talon(RobotMap.SPARK_driveRightFront);
    this.driveLeft = new MotorControllerGroup(driveLeftFront);
    this.driveRight = new MotorControllerGroup(driveRightFront);
    this.drive = new DifferentialDrive(driveLeft, driveRight);
    //this.driveRight.setInverted(true);
    //CommandScheduler.getInstance().registerSubsystem(RobotContainer.r_driveTrainSubsystem);
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
    drive.arcadeDrive(xSpeed*speedmod, zRotation*speedmod);
  }
  public void stop(){
    drive.stopMotor();
  }

  public void initDefaultCommand(){
    setDefaultCommand(new JoystickArcadeDrive());
    //probably a bad idea, passing an object into an object
  }
}
