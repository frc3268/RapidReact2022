// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Scooper extends SubsystemBase {

  Spark scoopmotor;  
  /** Creates a new ExampleSubsystem. */
  public Scooper() {
<<<<<<< HEAD
    this.scoopmotor = new Spark(RobotMap.SPARK_scoopBall);
    
=======
      this.scoopmotor = new Spark(RobotMap.SPARK_scoopBall);

>>>>>>> 55aacd891e442e560f2700b9867d9a03e603db83
  }

  public void setScoop(double speed){
    scoopmotor.set(speed);
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
    scoopmotor.stopMotor();
  }

  public void initDefaultCommand(){
    //probably a bad idea, passing an object into an object
  }
}
