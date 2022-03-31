// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TalonMotors extends SubsystemBase {

  Talon motor;  
  public boolean isSet;
  /** Creates a new ExampleSubsystem. */
  public TalonMotors(int MotorPort,boolean startSet) {
      isSet = startSet;
      this.motor = new Talon(MotorPort);
      //CommandScheduler.getInstance().registerSubsystem(RobotContainer.r_ScooperSubsystem);

  }

  public void setMotor(double speed){
    motor.set(speed);
  }

  public void toggleMotor(double speed){
    if(isSet==true){
      stop();
      isSet = false;
    }else {
      setMotor(speed);
      isSet = true;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
  public void stop(){
    motor.stopMotor();
  }

  public void initDefaultCommand(){
    
  }
}
