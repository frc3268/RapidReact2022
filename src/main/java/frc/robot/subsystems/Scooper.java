// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Scooper extends SubsystemBase {

  Talon scoopmotor;
  Talon scoopflywheel;

  /** Creates a new ExampleSubsystem. */
  public Scooper() {
    this.scoopmotor = new Talon(RobotMap.TALON_scoopBall);
    this.scoopflywheel = new Talon(RobotMap.TALON_scoopFlywheel);
  }

  public void setScoop(double speed) {
    scoopmotor.set(speed);
  }

  public void setScoopFlywheel(double state) {
    scoopflywheel.set(state);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void stop() {
    scoopmotor.stopMotor();
  }

  public void initDefaultCommand() {
    // probably a bad idea, passing an object into an object
  }
}
