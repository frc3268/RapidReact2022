// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;



public class Shooter extends SubsystemBase {

  CANSparkMax shootmotor;
  PIDController shootpid;
  private SparkMaxPIDController m_pidController;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM;
  public boolean isSet;
  /** Creates a new ExampleSubsystem. */
  public Shooter(boolean startSet) {
      this.shootmotor = new CANSparkMax(RobotMap.SPARK_shootBall, MotorType.kBrushed);
      this.m_pidController = shootmotor.getPIDController();
      // PID coefficients, tune these based on idk what
      kP = 6e-5; 
      kI = 0.0001;
      kD = 0.0001; 
      kIz = 0.0001; 
      kFF = 0.000015; 
      kMaxOutput = 1; 
      kMinOutput = -1;
      //RPM range for high goal: 3500-5000
      maxRPM = 4500;
      isSet = startSet;

      // set PID coefficients
      m_pidController.setP(kP);
      m_pidController.setI(kI);
      m_pidController.setD(kD);
      m_pidController.setIZone(kIz);
      m_pidController.setFF(kFF);
      m_pidController.setOutputRange(kMinOutput, kMaxOutput);


      //CommandScheduler.getInstance().registerSubsystem(RobotContainer.r_ShooterSubsystem);
  }

  public void setShoot(double speed){
    //m_pidController.setReference(speed*maxRPM, ControlType.kVelocity);
    shootmotor.set(speed);
  }
  public void toggleMotor(double speed){
    if(isSet==true){
      stop();
      isSet = false;
    }else {
      setShoot(speed);
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
    shootmotor.stopMotor();
  }

  public void initDefaultCommand(){
    //probably a bad idea, passing an object into an object
  }
}
