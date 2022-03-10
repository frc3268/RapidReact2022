// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoRoutine;
import frc.robot.commands.JoystickArcadeDrive;
import frc.robot.commands.TimedAutonomousArcadeDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Scooper;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

//working r
/** 
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final DriveTrain r_driveTrainSubsystem = new DriveTrain();
  public static final Scooper r_ScooperSubsystem = new Scooper();
  public static final Shooter r_ShooterSubsystem = new Shooter();
  public static final PowerDistribution r_powerDistributor = new PowerDistribution();

  Command m_autoCommand = new AutoRoutine();

  Command m_arcadeDriveCommand = new JoystickArcadeDrive();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }
  // Hello hi 3 ///

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  public Command getArcadeDriveCommand(){
    return m_arcadeDriveCommand;
  }
}
//3
//robot 2 checking in, doing crimes causeing sin